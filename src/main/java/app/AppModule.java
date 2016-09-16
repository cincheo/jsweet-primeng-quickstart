package app;

import app.cars.CarService;
import def.angular.core.NgModule;
import def.angular.forms.FormsModule;
import def.angular.http.HttpModule;
import def.angular.platform_browser.BrowserModule;
import def.primeng.primeng.ButtonModule;
import def.primeng.primeng.DataTableModule;
import def.primeng.primeng.DialogModule;
import def.primeng.primeng.InputTextModule;

@NgModule( //
		imports = { BrowserModule.class, FormsModule.class, HttpModule.class, InputTextModule.class,
				DataTableModule.class, ButtonModule.class, DialogModule.class }, //
		declarations = { AppComponent.class }, //
		bootstrap = { AppComponent.class }, //
		providers = { CarService.class })
public class AppModule {

}
