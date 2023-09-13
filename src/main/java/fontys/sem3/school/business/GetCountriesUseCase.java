package fontys.sem3.school.business;

import fontys.sem3.school.domain.Country;
import fontys.sem3.school.domain.GetCountriesResponse;
import fontys.sem3.school.domain.UpdateStudentRequest;
import fontys.sem3.school.persistence.entity.CountryEntity;

public interface GetCountriesUseCase {
    GetCountriesResponse getCountries();
    CountryEntity createCountry(CountryEntity country);

    void updateCountry(CountryEntity request);
}
