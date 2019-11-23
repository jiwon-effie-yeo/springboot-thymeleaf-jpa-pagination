package boot.jpa.pagination.domain.hero;

import boot.jpa.pagination.dto.HeroFindAllResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.awt.print.Pageable;

public interface HeroRepository extends JpaRepository<Hero, Long> {

    @Query( "select h " +
            "from Hero h " +
            "order by h.id desc")
    Page<HeroFindAllResponseDto> HeroFindAllResponse(Pageable pageable);

}
