import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LaptopComponentComponent } from './components/laptop-component/laptop-component.component';
import { AppComponent } from './app.component';
import { PageNotFoundComponent } from './components/page-not-found/page-not-found.component';

const routes: Routes = [





{
  path:'laptop',
  component:LaptopComponentComponent
},
{
  path:'**',
  component:PageNotFoundComponent
}


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { 


}
