package pl.mlisowski.multilanguage.label.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.mlisowski.multilanguage.label.domain.dto.LabelDto;

import java.util.List;

@RestController
@RequestMapping("/labels")
public class LabelController {

    @GetMapping
    public List<LabelDto> getLabel(){
        return List.of(new LabelDto("Hello from Spring!"));
    }

}
