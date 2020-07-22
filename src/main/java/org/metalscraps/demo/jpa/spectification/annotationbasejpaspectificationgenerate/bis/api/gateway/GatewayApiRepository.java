package org.metalscraps.demo.jpa.spectification.annotationbasejpaspectificationgenerate.bis.api.gateway;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface GatewayApiRepository extends JpaRepository<GatewayApi, UUID>, JpaSpecificationExecutor<GatewayApi> {

}
