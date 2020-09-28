import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatGridListModule } from '@angular/material/grid-list';
import { MatCardModule } from '@angular/material/card';
import { MatMenuModule } from '@angular/material/menu';
import { MatIconModule } from '@angular/material/icon';
import { MatButtonModule } from '@angular/material/button';
import { LayoutModule } from '@angular/cdk/layout';
import { MatTableModule } from '@angular/material/table';
import { MatPaginatorModule } from '@angular/material/paginator';
import { MatSortModule } from '@angular/material/sort';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatTabsModule } from '@angular/material/tabs';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { FlexLayoutModule } from '@angular/flex-layout';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MatInputModule } from '@angular/material/input';
import { MatSnackBarModule } from '@angular/material/snack-bar';
import { BaseInterceptor } from './core';
import { MatDividerModule } from '@angular/material/divider';
import {
  RecipientListComponent,
  RecipientService,
  RecipientInfoComponent,
  RecipientContainerComponent,
} from './recipient';
import {
  OfferContainerComponent,
  OfferInfoComponent,
  OfferListComponent,
  OfferService,
} from './offer';
import {
  DiscountApplyComponent,
  DiscountContainerComponent,
  DiscountsByRecipientPipe,
  DiscountService,
  DiscountToggleListComponent,
} from './discount';
@NgModule({
  declarations: [
    AppComponent,
    RecipientListComponent,
    RecipientInfoComponent,
    OfferListComponent,
    OfferInfoComponent,
    RecipientContainerComponent,
    OfferContainerComponent,
    DiscountContainerComponent,
    DiscountApplyComponent,
    DiscountToggleListComponent,
    DiscountsByRecipientPipe,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatGridListModule,
    MatCardModule,
    MatMenuModule,
    MatIconModule,
    MatButtonModule,
    LayoutModule,
    MatTableModule,
    MatPaginatorModule,
    MatSortModule,
    HttpClientModule,
    MatToolbarModule,
    MatTabsModule,
    FlexLayoutModule,
    FormsModule,
    ReactiveFormsModule,
    MatInputModule,
    MatSnackBarModule,
    MatDividerModule,
  ],
  providers: [
    RecipientService,
    OfferService,
    DiscountService,
    {
      provide: HTTP_INTERCEPTORS,
      useClass: BaseInterceptor,
      multi: true,
    },
  ],
  bootstrap: [AppComponent],
})
export class AppModule {}
