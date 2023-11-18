package com.cbfacademy.apiassessment.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cbfacademy.apiassessment.model.Investment;
import com.cbfacademy.apiassessment.service.InvestmentService;

@RestController
@RequestMapping("/api/v1/portfolios")
public class InvestmentController {

    // @Autowired
    private final InvestmentService service;

    // investment service constructor
    InvestmentController(InvestmentService service) {
        this.service = service;
    }

    // GET all investments
    @GetMapping("{portfolioId}/investments")
    public List<Investment> getAllPortfolios(@PathVariable UUID portfolioId) {
        return service.getAllInvesments(portfolioId);
    }

    // GET investment by id
    @GetMapping("{portfolioId}/investments/{investmentId}")
    public Investment getInvestmentById(@PathVariable UUID portfolioId, @PathVariable UUID investmentId) {
        return service.getInvestmentById(portfolioId, investmentId);
    }

    // create a new investment
    @PostMapping(path = "{portfolioId}/investments/new", produces = "application/json")
    public void createInvestment(@PathVariable UUID portfolioId, @RequestBody Investment investment) {
        service.createOrUpdateInvestment(portfolioId, investment);
    }

    // update an investment
    @PutMapping("/{portfolioId}/investments/{investmentId}")
    public void updateInvestment(@PathVariable UUID portfolioId, @PathVariable UUID investmentId,
            @RequestBody Investment investment) {
        service.createOrUpdateInvestment(portfolioId, investment);
    }

    // delete an investment
    @DeleteMapping("{portfolioId}/investments/{investmentId}")
    public void deleteInvestment(@PathVariable UUID portfolioId, @PathVariable UUID investmentId) {
        service.deleteInvestment(portfolioId, investmentId);
    }

    // get investments sorted (by type, name, symbol, shareQuantity, purchasePrice,
    // totalValue or currentValue)
    @GetMapping("{portfolioId}/investments/sorted")
    public List<Investment> getSortedInvestments(@PathVariable UUID portfolioId,
            @RequestParam(name = "sort", defaultValue = "name") String sortCriteria,
            @RequestParam(name = "order", defaultValue = "asc") String sortOrder) {
        return service.getSortedInvestments(portfolioId, sortCriteria, sortOrder);

    }

    // filter investments by type
    @GetMapping("{portfolioId}/investments/filter-by-type")
    public List<Investment> getInvestmentsFilteredByType(@PathVariable UUID portfolioId,
            @RequestParam(name = "investmentType", defaultValue = "Stock") String investmentType) {
        return service.filterInvestmentsByType(portfolioId, investmentType);
    }
}
