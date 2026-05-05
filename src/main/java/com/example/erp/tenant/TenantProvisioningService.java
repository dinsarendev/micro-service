package com.example.erp.tenant;

import com.example.erp.common.BadRequestException;
import lombok.RequiredArgsConstructor;
import org.flywaydb.core.Flyway;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.util.regex.Pattern;

@Service
@RequiredArgsConstructor
public class TenantProvisioningService {
    private static final Pattern TENANT_PATTERN = Pattern.compile("^[a-z][a-z0-9_]{2,62}$");

    private final TenantRepository repo;
    private final JdbcTemplate jdbc;
    private final DataSource ds;

    public Tenant register(String tenantId, String name) {
        if (!TENANT_PATTERN.matcher(tenantId).matches()) {
            throw new BadRequestException("Invalid tenant id format");
        }
        String createSchemaSql = "CREATE SCHEMA IF NOT EXISTS \"" + tenantId + "\"";
        jdbc.execute(createSchemaSql);
        Flyway.configure().dataSource(ds).schemas(tenantId).locations("classpath:db/migration/tenant").load().migrate();
        return repo.save(new Tenant(null, tenantId, name));
    }
}
