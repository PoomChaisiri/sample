package th.co.ais.internal.sample.log;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/log")
public class LogController {

    private final LogService logService;

    public LogController(LogService logService) {
        this.logService = logService;
    }

    @GetMapping("")
    public ResponseEntity<List<LogResponse>> getLog() {
        return ResponseEntity.ok(logService.getAllLog());
    }



}
