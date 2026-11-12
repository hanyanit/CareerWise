
import { Injectable, signal, inject } from '@angular/core';
import { DOCUMENT } from '@angular/common';

export type Theme = 'light' | 'dark';

@Injectable({
  providedIn: 'root'
})
export class ThemeService {

  private readonly document = inject(DOCUMENT);
  private readonly storageKey = 'careerwise_theme';

  readonly theme = signal<Theme>('light');

  constructor() {
    this.loadTheme();
  }

  private loadTheme(): void {
    let savedTheme: string | null = null;

    try {
      savedTheme = localStorage.getItem(this.storageKey);
    } catch {
      savedTheme = null;
    }

    this.setTheme(savedTheme === 'dark' ? 'dark' : 'light');
  }

  setTheme(theme: Theme): void {
    this.theme.set(theme);

    this.document.documentElement.classList.toggle(
      'dark',
      theme === 'dark'
    );

    try {
      localStorage.setItem(this.storageKey, theme);
    } catch {
      // Theme still works for the current session.
    }
  }

  toggleTheme(): void {
    this.setTheme(
      this.theme() === 'light' ? 'dark' : 'light'
    );
  }
}
