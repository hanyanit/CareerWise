import { HttpInterceptorFn } from '@angular/common/http';
import { inject } from '@angular/core';
import { AuthService } from '../services/auth.service';

/**
 * Functional HTTP interceptor that automatically attaches the user's JWT token
 * to all outgoing requests if the user is authenticated.
 */
export const authInterceptor: HttpInterceptorFn = (req, next) => {
  const auth = inject(AuthService);
  const user = auth.currentUser();

  if (user?.token) {
    const authReq = req.clone({
      setHeaders: {
        Authorization: `Bearer ${user.token}`
      }
    });
    return next(authReq);
  }

  return next(req);
};
