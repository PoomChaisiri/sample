package th.co.ais.internal.sample.log;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogService {

    private final LogRepository logRepository;

    public LogService(LogRepository logRepository) {
        this.logRepository = logRepository;
    }

    public List<LogResponse> getAllLog() {
        return logRepository.findAllWithPagination().stream().map(Log::toResponse).toList();
    }
}
