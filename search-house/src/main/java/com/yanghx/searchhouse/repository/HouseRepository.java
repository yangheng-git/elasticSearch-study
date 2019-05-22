package com.yanghx.searchhouse.repository;

import com.yanghx.searchhouse.entity.House;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author yangHX
 * createTime  2019/5/22 18:25
 */
public interface HouseRepository extends PagingAndSortingRepository<House, Long>, JpaSpecificationExecutor<House> {


}
