package com.pvs.security.sec;

public interface SecurityParams {
    public static final String JWT_HEADER_NAME="Authorization";
    public static final String SECRET="Anouar Salhi";
    public static final long EXPIRATION=60*24*3600;
    public static final String HEADER_PREFIX="Bearer ";
}
