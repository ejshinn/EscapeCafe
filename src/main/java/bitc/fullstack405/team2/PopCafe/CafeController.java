package bitc.fullstack405.team2.PopCafe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class CafeController {

    @Autowired
    private CafeService cafeService;
    @RequestMapping("/locationMain")
    public ModelAndView selectLocationList() throws Exception {
        ModelAndView mv = new ModelAndView("location/locationmain");

        List<CafeDTO> cafeList = cafeService.selectCafeList();
        mv.addObject("cafeList", cafeList);

        return mv;
    }




}
