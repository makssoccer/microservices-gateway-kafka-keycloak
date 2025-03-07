import { PassedInitialConfig } from 'angular-auth-oidc-client';

export const authConfig: PassedInitialConfig = {
  config: {
    // версия для без kubernetes
    // authority: 'http://localhost:8181/realms/spring-microservice-security-realm',
    // Версия для Штурвала
    authority: 'http://keycloak.default.svc.cluster.local:8080/realms/spring-microservice-security-realm',
    redirectUrl: window.location.origin,
    postLogoutRedirectUri: window.location.origin,
    clientId: 'angular-client',
    scope: 'openid profile offline_access',
    responseType: 'code',
    silentRenew: true,
    useRefreshToken: true,
    renewTimeBeforeTokenExpiresInSeconds: 30,
  }
}
