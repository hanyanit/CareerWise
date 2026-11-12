
import { Component, inject } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { ToastComponent } from './components/toast/toast.component';
import { ThemeService } from './services/theme.service';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, ToastComponent],
  template: `<router-outlet></router-outlet><app-toast></app-toast>`
})
export class AppComponent {
  title = 'client';

  private themeService = inject(ThemeService);
}
