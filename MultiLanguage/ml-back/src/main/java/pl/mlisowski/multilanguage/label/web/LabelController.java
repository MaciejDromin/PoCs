package pl.mlisowski.multilanguage.label.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.mlisowski.multilanguage.label.domain.dto.LabelDto;

@RestController
@RequestMapping("/label")
public class LabelController {

    @GetMapping
    public LabelDto getLabel(){
        return new LabelDto("Hello from Spring!");
    }

}
