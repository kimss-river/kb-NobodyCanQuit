package nobodyCanQuit.service.address;

import nobodyCanQuit.web.model.address.AddressCommand;
import nobodyCanQuit.web.model.address.Result;
import nobodyCanQuit.web.model.dust.DustArea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.*;

@Service
public class DustAreaCoordService {

    @Autowired
    private CoordService coordService;

    public List<DustArea> getConvertedList(AddressCommand addressCommand, List<DustArea> dustList) throws IOException {

        List<Result> list = addressCommand.getResultList();
        List<Result> names = new ArrayList<>(list.size());

        for (Result r : list) {
            names.add(new Result(
                    r.getName().contains(" ") ? r.getName().substring(0, r.getName().indexOf(" ")) : r.getName(),
                    r.getX(),
                    r.getY())
            );
        }

        HashSet<Result> namesSet = new HashSet<>(names);
        names = new ArrayList<>(namesSet);

        HashSet<DustArea> dustSet = new HashSet<>(dustList);
        dustList = new ArrayList<>(dustSet);

        names.sort((s, b)-> s.toString().compareTo(b.toString()));
        dustList.sort((s,b)-> s.toString().compareTo(b.toString()));

        dustList = coordService.convert(names, dustList,
                CoordService.CoordSystem.UTM, CoordService.CoordSystem.WGS84);

        return dustList;
    }

}
