import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleEmitter;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.core.SingleOnSubscribe;
import io.reactivex.rxjava3.internal.operators.single.SingleMap;

import java.util.List;
import java.util.Map;
import java.util.concurrent.FutureTask;

class CountriesServiceSolved implements CountriesService {

    @Override
    public Single<String> countryNameInCapitals(Country country) {
        return Single.create(emitter -> {
            emitter.onSuccess(country.name.toUpperCase());
        });
        // put your solution here
    }

    public Single<Integer> countCountries(List<Country> countries) {
        return Single.just(countries.size());

    }

    public Observable<Long> listPopulationOfEachCountry(List<Country> countries) {
        Long[] populations=new Long[countries.size()];
        for (int i = 0; i < countries.size(); i++) {
            populations[i]=countries.get(i).population;
        }
        return Observable.fromArray(populations);
    }

    @Override
    public Observable<String> listNameOfEachCountry(List<Country> countries) {
        String[] names=new String[countries.size()];
        for (int i = 0; i < countries.size(); i++) {
            names[i]=countries.get(i).name;
        }
        return Observable.fromArray(names);
    }

    @Override
    public Observable<Country> listOnly3rdAnd4thCountry(List<Country> countries) {
        return Observable.just(countries.get(2) , countries.get(3));
    }

    @Override
    public Single<Boolean> isAllCountriesPopulationMoreThanOneMillion(List<Country> countries) {
        return Single.create(emitter -> {
            boolean flag=true;
            for (int i = 0; i < countries.size(); i++) {
                if (countries.get(i).population<=1000000){
                    flag=false;
                    break;
                }
            }
            emitter.onSuccess(flag);
        });
    }

    @Override
    public Observable<Country> listPopulationMoreThanOneMillion(List<Country> countries) {
        return Observable.create(emitter -> {
            for (int i = 0; i < countries.size(); i++) {
                if (countries.get(i).population>1000000){
                    emitter.onNext(countries.get(i));
                }
            }
        });
    }

    @Override
    public Observable<Country> listPopulationMoreThanOneMillionWithTimeoutFallbackToEmpty(final FutureTask<List<Country>> countriesFromNetwork) {
        return null; // put your solution here
    }

    @Override
    public Observable<String> getCurrencyUsdIfNotFound(String countryName, List<Country> countries) {
        return null; // put your solution here
    }

    @Override
    public Observable<Long> sumPopulationOfCountries(List<Country> countries) {
        return Observable.create(emitter -> {
            long sum=0L;
            for (int i = 0; i < countries.size(); i++) {
                sum+=countries.get(i).population;
            }
            emitter.onNext(sum);
        });
    }

    @Override
    public Single<Map<String, Long>> mapCountriesToNamePopulation(List<Country> countries) {
        return null; // put your solution here
    }

    @Override
    public Observable<Long> sumPopulationOfCountries(Observable<Country> countryObservable1,
                                                     Observable<Country> countryObservable2) {
        return null; // put your solution here
    }

    @Override
    public Single<Boolean> areEmittingSameSequences(Observable<Country> countryObservable1,
                                                    Observable<Country> countryObservable2) {
        return null; // put your solution here
    }
}
