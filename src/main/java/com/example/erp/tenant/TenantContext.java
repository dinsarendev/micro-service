package com.example.erp.tenant;

public final class TenantContext {
    private static final ThreadLocal<String> CURRENT = new ThreadLocal<>();
    public static void setTenant(String tenant) { CURRENT.set(tenant); }
    public static String getTenant() { return CURRENT.get() == null ? "public" : CURRENT.get(); }
    public static void clear() { CURRENT.remove(); }
    private TenantContext() {}
}
