package app;

import static jsweet.util.Lang.array;

import app.cars.Car;
import app.cars.CarService;
import def.angular.core.Component;
import def.dom.Event;
import def.js.Array;

class PrimeCar extends Car {
	public String vin;
	public int year;
	public String brand;
	public String color;
	public String other = "xxx";

	public PrimeCar(String vin, int year, String brand, String color) {
		super();
		this.vin = vin;
		this.year = year;
		this.brand = brand;
		this.color = color;
	}

	public PrimeCar() {
		super();
	}

}

@Component(templateUrl = "app/app.component.html", selector = "my-app")
public class AppComponent {

	boolean displayDialog;

	Car car = new PrimeCar();

	Car selectedCar;

	boolean newCar;

	Array<Car> cars = new Array<>(new PrimeCar("test", 1993, "Volvo", "red"));

	private CarService carService;

	public AppComponent(CarService carService) {
		this.carService = carService;
	}

	void ngOnInit() {
		this.carService.getCarsMedium().thenOnFulfilledFunction(cars -> this.cars = array(cars));
	}

	void showDialogToAdd() {
		this.newCar = true;
		this.car = new PrimeCar();
		this.displayDialog = true;
	}

	void save() {
		if (this.newCar)
			this.cars.push(this.car);
		else
			array(this.cars)[this.findSelectedCarIndex()] = this.car;

		this.car = null;
		this.displayDialog = false;
	}

	void delete() {
		this.cars.splice(this.findSelectedCarIndex(), 1);
		this.car = null;
		this.displayDialog = false;
	}

	void onRowSelect(Event event) {
		this.newCar = false;
		this.car = this.cloneCar(event.$get("data"));
		this.displayDialog = true;
	}

	Car cloneCar(Car c) {
		return new PrimeCar(c.vin, c.year, c.brand, c.color);
	}

	int findSelectedCarIndex() {
		return (int) this.cars.indexOf(this.selectedCar);
	}
}
