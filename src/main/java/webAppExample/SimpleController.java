package webAppExample;

import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/api/")
public class SimpleController {
    private final RecordRepository recordRepository;

    public SimpleController(RecordRepository recordRepository) {
        this.recordRepository = recordRepository;
    }

    @GetMapping(value = "testPath/{a}/{b}")
    String testPath(@PathVariable(name = "a") long a, @PathVariable(name = "b") long b){
        return "WOW = " + a + " b = " + b;
    }

    @GetMapping(value = "recordsStats")
    RecordsStatsDto recordsStats(){
        long count = recordRepository.count();
        long nullCount = recordRepository.countByValue(null);
        return new RecordsStatsDto(count, count - nullCount);
    }

    @GetMapping(value = "add")
    String addRecord(@RequestParam(name = "key") String key, @RequestParam(name = "value", required = false) String value){
        recordRepository.save(new RecordEntity(key, value));
        return "Added: " + key + " -> " + value;
    }

    @GetMapping(value = "get")
    Object getRecord(@RequestParam(name = "key") String key){
        Optional<RecordEntity> recordOpt = recordRepository.findById(key);
        if (recordOpt.isPresent()){
            RecordEntity recordEntity = recordOpt.get();
            return new RecordDto(recordEntity.getKey(), recordEntity.getValue());
        } else
            return "Key " + key + " not found!";
    }

    @PostMapping(value = "addWithBody")
    String addWithBody(@RequestBody RecordDto record){
        recordRepository.save(new RecordEntity(record.getKey(), record.getValue()));
        return "Added: " + record.getKey() + " -> " + record.getValue();
    }
}
