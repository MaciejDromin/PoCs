package pl.mlisowski.multilanguage.label.web;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.mlisowski.multilanguage.label.application.LabelService;
import pl.mlisowski.multilanguage.label.domain.Label;
import java.util.List;

@RestController
@RequestMapping("/labels")
@RequiredArgsConstructor
public class LabelController {

    private final LabelService labelService;

    @GetMapping
    public List<Label> getLabel(@RequestParam String lang){
        return labelService.findAllByLang(lang);
    }

    @PostMapping
    public Label saveLabel(@RequestBody Label label){
        return labelService.save(label);
    }

}
