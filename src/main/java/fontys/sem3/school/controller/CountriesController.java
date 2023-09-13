package fontys.sem3.school.controller;

import fontys.sem3.school.business.GetCountriesUseCase;
import fontys.sem3.school.domain.Country;
import fontys.sem3.school.domain.GetCountriesResponse;
import fontys.sem3.school.persistence.CountryRepository;
import fontys.sem3.school.persistence.entity.CountryEntity;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/countries")
@AllArgsConstructor
public class CountriesController {
    private final GetCountriesUseCase getCountriesUseCase;

    @GetMapping
    public ResponseEntity<GetCountriesResponse> getCountries() {
        return ResponseEntity.ok(getCountriesUseCase.getCountries());
    }

//    @PostMapping
//    public Country createCountry (@RequestBody Country request){
//        return request;
//    }

    @PostMapping()
    public ResponseEntity<CountryEntity> createCountry(@RequestBody CountryEntity request) {
        CountryEntity response = getCountriesUseCase.createCountry(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("{id}")
    public ResponseEntity<Void> updateCountry(@PathVariable("id") long id, @RequestBody @Valid CountryEntity request){
        request.setId(id);
        getCountriesUseCase.updateCountry(request);
        return ResponseEntity.noContent().build();
    }



}
