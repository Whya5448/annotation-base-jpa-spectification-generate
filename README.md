
# APIs
## GatewayAPI search
Endpoints: http://localhost:8080/api/gateway

**Map to GatewayApiSearchRequest.class**

_SearchRequest 내부에서 Authorities를 가져와 권한 체크를 한다._

|제목|조건|내용|설명|예제|
|------|---|---|---|---|
|All|Or|전체 검색|조건에 All 이 들어가는 모든 필드에 값을 주입함.|Z
|name|All/Or|API 이름 검색|GatewayApi entity 내 name 필드 Like 검색|Z
|uri|All/Or|API URI 검색|GatewayApi entity 내 uri 필드 Like 검색|ZZ
|service|All/Or|API 서비스명 검색|GatewayApi entity 내 service entity 내 name 필드 Like 검색|Service
|createId|All/Or|생성자 ID 검색|GatewayApi entity 내 creator entity 내 id 필드 Like 검색|4
|state|And|상태 검색|GatewayApi entity 내 state 필드 equals 검색|SAVED
|startDate|Or|생성일 범위 검색|GatewayApi entity 내 createDate 필드 범위 최소 한계 검색|1595089296001
|endDate|Or|생성일 범위 검색|GatewayApi entity 내 createDate 필드 범위 최대 한계 검색|1595434899355

## GatewayAPI preview search
Endpoints: http://localhost:8080/api/gateway/preview

**Map to GatewayApiPreviewSearchRequest.class**

_검색 권한의 제한은 없으나 정보의 양이 적다._

|제목|조건|내용|설명|예제|
|------|---|---|---|---|
|All|Or|전체 검색|조건에 All 이 들어가는 모든 필드에 값을 주입함.|Z
|name|All/Or|API 이름 검색|GatewayApi entity 내 name 필드 Like 검색|Z
|uri|All/Or|API URI 검색|GatewayApi entity 내 uri 필드 Like 검색|ZZ
|service|All/Or|API 서비스명 검색|GatewayApi entity 내 service entity 내 name 필드 Like 검색|Service
|createId|All/Or|생성자 ID 검색|GatewayApi entity 내 creator entity 내 id 필드 Like 검색|4
|state|And|상태 검색|GatewayApi entity 내 state 필드 equals 검색|SAVED
|startDate|Or|생성일 범위 검색|GatewayApi entity 내 createDate 필드 범위 최소 한계 검색|1595089296001
|endDate|Or|생성일 범위 검색|GatewayApi entity 내 createDate 필드 범위 최대 한계 검색|1595434899355


## Employer search
Endpoints: http://localhost:8080/api/employer

**Map to EmployerSearchRequest.class**

_임직원 Database 검색._

_SearchRequest 내부에서 deptId가 null이 아닌 조건을 추가로 건다._

|제목|조건|내용|설명|예제|
|------|---|---|---|---|
|empNo|Or|전체 검색|조건에 All 이 들어가는 모든 필드에 값을 주입함.|Z
|name|All/Or|API 이름 검색|GatewayApi entity 내 name 필드 Like 검색|Z
|dept|All/Or|API URI 검색|GatewayApi entity 내 uri 필드 Like 검색|ZZ
|state|And|상태 검색|GatewayApi entity 내 state 필드 equals 검색|SAVED

