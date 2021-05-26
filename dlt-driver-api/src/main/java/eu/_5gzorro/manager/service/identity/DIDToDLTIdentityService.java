package eu._5gzorro.manager.service.identity;

/**
 * Queries the identity api to resolve a parties DID to their actual
 */
public interface DIDToDLTIdentityService {
  String resolveIdentity(String did);
}
