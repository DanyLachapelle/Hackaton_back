package school.token.hackaton_groupe7.controller.DateUser;
import org.springframework.data.domain.Pageable;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import school.token.hackaton_groupe7.application.features.dateUser.queries.DateUserQueryProcessor;
import school.token.hackaton_groupe7.application.features.dateUser.queries.GetbyIdUser.DateUserGetByIdUserOutput;
import school.token.hackaton_groupe7.application.features.dateUser.queries.getAll.DateUserGetAllOutput;
import school.token.hackaton_groupe7.application.features.dateUser.queries.getBudgetByUserAndMonthAndYear.DateUserGetBudgetByUserAndMonthAndYearQuery;
import school.token.hackaton_groupe7.application.features.dateUser.queries.getById.DateUserGetByIdOutput;
import school.token.hackaton_groupe7.application.features.dateUser.queries.getByUserMonthYear.DateUserGetByUserMonthYearQuery;
import school.token.hackaton_groupe7.infrastructure.repositories.IDateUserRepository;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/dateUser")
@Tag(name = "DateUserController")
public class DateUserQueryController {
    private final DateUserQueryProcessor dateUserQueryProcessor;
    private final IDateUserRepository dateUserRepository;

    public DateUserQueryController(DateUserQueryProcessor dateUserQueryProcessor, IDateUserRepository dateUserRepository) {
        this.dateUserQueryProcessor = dateUserQueryProcessor;
        this.dateUserRepository = dateUserRepository;
    }

    @GetMapping("/all")
    @ApiResponse(responseCode = "200")@ApiResponse(responseCode = "200")
    public Iterable<DateUserGetAllOutput.DateUser> getAll(Pageable pageable) {
        return dateUserQueryProcessor.getAll(pageable).dateUsers;
    }

    @GetMapping("/test-db")
    public String testDbConnection() {
        long count = dateUserRepository.count();
        return "La base de donnÃ©es contient " + count + " utilisateurs.";
    }

    @GetMapping("{id}")
    @ApiResponses({
            @ApiResponse(responseCode = "200"),
            @ApiResponse(responseCode = "404")
    })
    public ResponseEntity<DateUserGetByIdOutput> getById(@PathVariable() int id) {
        DateUserGetByIdOutput dateUser = dateUserQueryProcessor.getById(id);
        if(dateUser == null) {
            //return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(dateUser, HttpStatus.OK);
    }

    @GetMapping("user/{id_user}")
    @ApiResponses({
            @ApiResponse(responseCode = "200"),
            @ApiResponse(responseCode = "404")
    })
    public ResponseEntity<DateUserGetByIdUserOutput> getByIdUser(@PathVariable() int id_user) {
        DateUserGetByIdUserOutput dateUser = dateUserQueryProcessor.getByIdUser(id_user);
        if(dateUser == null) {
            //return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(dateUser, HttpStatus.OK);
    }

    @GetMapping("userBudget/{id}/{year}/{month}")
    @ApiResponses({
            @ApiResponse(responseCode = "200"),
            @ApiResponse(responseCode = "404")
    })
    public double getBudgetFromUser(@PathVariable() int id, @PathVariable() int year, @PathVariable() int month) {
        DateUserGetBudgetByUserAndMonthAndYearQuery query = new DateUserGetBudgetByUserAndMonthAndYearQuery(id,month,year);
        return dateUserQueryProcessor.getBudgetByUserAndMonthAndYear(query);
    }

    @GetMapping("getByUserMonthYear/{idUser}/{year}/{month}")
    @ApiResponses({
            @ApiResponse(responseCode = "200"),
            @ApiResponse(responseCode = "404")
    })
    public int getByUserMonthYear(@PathVariable() int idUser, @PathVariable() int year, @PathVariable() int month) {
        DateUserGetByUserMonthYearQuery query = new DateUserGetByUserMonthYearQuery(idUser,month,year);
        return dateUserQueryProcessor.getByUserMonthYear(query);
    }


}
