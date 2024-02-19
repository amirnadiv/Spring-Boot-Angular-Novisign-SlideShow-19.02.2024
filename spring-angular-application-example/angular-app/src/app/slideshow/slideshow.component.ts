
import { Component, Input, OnDestroy, OnInit } from '@angular/core';
import { interval, Subscription } from 'rxjs';

@Component({
  selector: 'app-slideshow',
  templateUrl: './slideshow.component.html',
  styleUrls: ['./slideshow.component.css']
})
export class SlideshowComponent implements OnInit, OnDestroy {
  @Input() images: string[] = [];
  @Input() delay: number = 2000;

  currentImageIndex: number = 0;
  currentImage: string = '';
  private subscription: Subscription = new Subscription();

  constructor() { }

  ngOnInit(): void {
    this.showSlide();
  }

  ngOnDestroy(): void {
    this.subscription.unsubscribe();
  }

  private showSlide(): void {
    this.currentImage = this.images[this.currentImageIndex];
    this.currentImageIndex = (this.currentImageIndex + 1) % this.images.length;

    this.subscription = interval(this.delay).subscribe(() => {
      this.showSlide();
    });
  }
}
