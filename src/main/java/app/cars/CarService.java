package app.cars;

import static jsweet.util.Globals.$get;

import def.angular.core.Injectable;
import def.angular.http.Http;
import def.es6_promise.Promise;

@Injectable()
public class CarService {

	private Http http;

	public CarService(Http http) {
		this.http = http;
	}

	public Promise<Car[]> getCarsMedium() {
		return this.http.get("app/resources/data/cars-medium.json").toPromise()
				.thenOnFulfilledFunction(res -> (Car[]) $get(res.json(), "data")) //
				.thenOnFulfilledFunction(data -> {
					return data;
				});
	}

}
