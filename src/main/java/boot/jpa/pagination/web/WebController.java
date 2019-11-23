package boot.jpa.pagination.web;

import boot.jpa.pagination.dto.HeroFindAllResponseDto;
import boot.jpa.pagination.service.HeroService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class WebController {

    private HeroService heroService;

    @GetMapping("/")
    public String main(Model model, @PageableDefault Pageable pageable) {
        Page<HeroFindAllResponseDto> pages = heroService.HeroFindAllResponse(pageable);
        model.addAttribute("pages",pages);

        //마이너스값이면 1page가 첫 페이지
        //5페이지부턴 (4-2) 2가 가장 첫번째 값
        int start = Math.max(1,pages.getNumber() - 2);
        int last = Math.min(start + 6, pages.getTotalPages());

        model.addAttribute("start", start);
        model.addAttribute("last", last);
        return "index";
    }
}
