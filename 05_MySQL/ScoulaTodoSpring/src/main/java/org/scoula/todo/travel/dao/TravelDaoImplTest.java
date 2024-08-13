package org.scoula.todo.travel.dao;

import com.opencsv.bean.CsvToBeanBuilder;
import org.scoula.todo.config.ProjectConfig;
import org.scoula.todo.travel.domain.TravelVO;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.sql.SQLException;
import java.util.List;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {ProjectConfig.class})
public class TravelDaoImplTest {
    @Autowired
    TravelDao dao;

    @Test
    void create() throws IOException, SQLException {
        //파일 stream을 쓸 때, 바이트/문자 구분. csv파일은 text 파일이므로 문자 단위의 스트림
        //CSV 첫줄의 명칭과 VO의 명칭이 같아야 함
        //순서로 맵핑이 아닌, 이름으로 맵핑하기 때문에
        List<TravelVO> members = new CsvToBeanBuilder<TravelVO>(new FileReader("travel.csv", StandardCharsets.UTF_8))
                .withType(TravelVO.class)
                .build()
                .parse();
        for(TravelVO travel : members) {
            System.out.println(travel);
            dao.create(travel);
        }
    }
}
