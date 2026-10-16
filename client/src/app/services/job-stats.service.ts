import { Injectable, inject } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, catchError, of } from 'rxjs';
import { environment } from '../../environments/environment';

export interface JobStats {
  views: number;
  newApplicationsToday: number;
}

@Injectable({
  providedIn: 'root'
})
export class JobStatsService {
  private http = inject(HttpClient);
  private apiBaseUrl = environment.apiBaseUrl;

  getStats(jobId: string): Observable<JobStats> {
    return this.http.get<JobStats>(`${this.apiBaseUrl}/jobs/${jobId}/stats`).pipe(
      catchError(err => {
        console.error('Failed to load job stats', err);
        return of({ views: 0, newApplicationsToday: 0 });
      })
    );
  }
}
