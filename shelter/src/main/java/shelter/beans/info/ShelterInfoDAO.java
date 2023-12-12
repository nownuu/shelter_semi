package shelter.beans.info;

import java.io.IOException;
import java.util.List;

public interface ShelterInfoDAO {
    List<ShelterInfoDTO> getShelterInfoList(int page, int pageSize) throws IOException;
}

