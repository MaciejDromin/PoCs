package pl.mlisowski.multilanguage.label.application;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.mlisowski.multilanguage.label.domain.Label;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LabelService {

    private final LabelRepository labelRepository;

    public List<Label> findAllByLang(String lang) {
        return labelRepository.findAllByLang(lang);
    }

    public Label save(Label label) {
        return labelRepository.save(label);
    }

}
