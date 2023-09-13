package fontys.sem3.school.business.impl;

import fontys.sem3.school.business.CountryIdValidator;
import fontys.sem3.school.business.GetCountriesUseCase;
import fontys.sem3.school.business.exception.InvalidCountryException;
import fontys.sem3.school.domain.Country;
import fontys.sem3.school.domain.GetCountriesResponse;
import fontys.sem3.school.persistence.CountryRepository;
import fontys.sem3.school.persistence.entity.CountryEntity;
import fontys.sem3.school.persistence.entity.StudentEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class GetCountriesUseCaseImpl implements GetCountriesUseCase {
    private final CountryRepository countryRepository;

    @Override
    public GetCountriesResponse getCountries() {
        List<Country> countries = countryRepository.findAll()
                .stream()
                .map(CountryConverter::convert)
                .toList();

        return GetCountriesResponse.builder()
                .countries(countries)
                .build();
    }
    @Override
    public CountryEntity createCountry(CountryEntity country) {
        if(countryRepository.existsByCode(country.getCode())){
            throw new InvalidCountryException("Country Code Already Exist");

        }
        return countryRepository.save(country);
    }

    @Override
    public void updateCountry(CountryEntity request) {
        CountryEntity checkCountry = countryRepository.findById(request.getId());

        checkCountry.setName(request.getName());
        countryRepository.save(checkCountry);
    }


}
