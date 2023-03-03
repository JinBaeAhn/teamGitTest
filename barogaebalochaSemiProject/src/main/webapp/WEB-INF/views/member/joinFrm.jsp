<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
    .wrap{
		width: 100%;
		margin: 0 auto;
	}
	.page-title{
		font-size: 40px;
	}
	.input-wrap>img{
		width: 100px;
		height: 100px;
	}
	.img-input{
		text-align: center;
	}
	.id-input{
		width: 70%;
   		padding: 0.8rem;
    	background-color: #fff;
    	outline: none;
    	border: 1px solid #ccc;
    	box-sizing: border-box;
	}
	.input-wrap{
		padding-top : 20px;
	}
    .phoneSel{
        width: 100px;
    }
    .input-form-short{
        width: 20%;
        padding: 0.8rem;
        background-color: #fff;
        outline: none;
        border: 1px solid #ccc;
        box-sizing: border-box;
    }
    .input-form-short:focus {
        box-shadow: 0 0 0 0.1rem #eee;
    }
    #img-view{
        width: 200px;
        border-radius: 50%;
    }
    #imgFile{
    	display : none;
    }
    .agree-content{
        width: 100%;
        height: 100px;
        overflow: scroll;
        border: 1px solid #ccc;
        font-size: 12px;
    }
</style>
</head>
<body>
	<%@ include file="/WEB-INF/views/common/header.jsp" %>
    <div class="wrap">
        <div class="page-content">
            <div class="page-title">회원가입</div>
                <form action="/join.do" method="post"  enctype="multipart/form-data">
                    <div class="input-wrap img-input">
                        <label for="imgFile">
                            <img src="img/profile.png" id="img-view">
                        </label>
                        <input type="file" name="imgFile" id="imgFile" accept=".jpg,.png,.jpeg" onchange="loadImg(this);" >
                    </div>
                    <div class="input-wrap">
                        <label for="memberId">아이디</label>
                        <div class="id-wrap">
                            <input type="text" name="memberId" id="memberId" class="input-form" placeholder="아이디를 입력해주세요" required>
                            <span id="ajaxCheckId"></span>
                        </div>
                    </div>
                    <div class="input-wrap">
                        <label for="memberPw">비밀번호</label>
                        <div>
                            <input type="text" name="memberPw" id="memberPw" class="input-form" placeholder="비밀번호를 입력해주세요(8~16글자)" required>
                        </div>
                        <span id="msg1"></span>
                    </div>
                    <div class="input-wrap">
                        <label for="memberPwRe">비밀번호 확인</label>
                        <div>
                            <input type="text" name="memberPwRe" id="memberPwRe" class="input-form" placeholder="비밀번호를 한번 더 입력해주세요" required>
                        </div>
                        <span id="msg2"></span>
                    </div>
                    <div class="input-wrap">
                        <label for="memberName">이름</label>
                        <input type="text" name="memberName" id="memberName" class="input-form"placeholder="실명을 입력해주세요" required>
                        <span></span>
                    </div>
                    <div class="input-wrap">
                        <label for="memberPhone">전화번호</label>
                        <div>
                            <select size="1" name="memberPhone1" class="input-form-short">
                                <option value="010">010</option>
                                <option value="011">011</option>
                                <option value="016">016</option>
                                <option value="017">017</option>
                                <option value="018">018</option>
                                <option value="019">019</option>
                            </select>
                            <input type="text" name="memberPhone2" id="memberPhone2" class="input-form-short" placeholder="'-'없이 입력해주세요" required>
                            <input type="text" name="memberPhone3" id="memberPhone3" class="input-form-short" placeholder="'-'없이 입력해주세요" required>
                        </div>
                    </div>
                    <div class="input-wrap">
                        <label for="memberAddr">지역</label>
                        <div>
                            <select size="1" name="memberAddr" id="memberAddr" class="input-form-short">
                                <option value="">지역선택</option>
                                <option value="서울">서울</option>
                                <option value="인천">인천</option>
                                <option value="부산">부산</option>
                                <option value="대구">대구</option>
                                <option value="대전">대전</option>
                                <option value="광주">광주</option>
                                <option value="울산">울산</option>
                                <option value="세종">세종</option>
                                <option value="경기">경기</option>
                                <option value="강원">강원</option>
                                <option value="충북">충북</option>
                                <option value="충남">충남</option>
                                <option value="전북">전북</option>
                                <option value="전남">전남</option>
                                <option value="경북">경북</option>
                                <option value="경남">경남</option>
                                <option value="제주">제주</option>
                            </select>
                        </div>
                    </div>
                    <div class="input-wrap">
                        <label for="memberMail">메일</label>
                        <div>
                            <input type="text" name="memberMail1" id="memberMail1" class="input-form-short" placeholder="이메일을 입력해주세요" required>
                            <span>@</span>
                            <input type="text" name="memberMail2" id="memberMail2" class="input-form-short" required>
                            <select size="1" class="input-form-short" id="mailSel">
                                <option value="">직접입력</option>
                                <option value="naver.com">네이버</option>
                                <option value="gmail.com">구글</option>
                                <option value="daum.net">다음</option>
                            </select>
                        </div>
                    </div>
                    <div class="input-wrap">
                        <label for="mailChk">이메일 인증</label>
                        <div>
                            <input type="text" name="mailChk" id="authCode" class="input-form-short" placeholder="인증번호를 입력해주세요.">
                            <button type="button" id="sendBtn" class="btn2 bc1 bs1">인증메일발송</button>
                            <div id="auth" style="display : none;">
                            	<button class="btn bc1" id="authBtn">인증하기</button>
                            	<span id="timeZone"></span>
                            	<span id="authMsg"></span>
                            </div>
                        </div>
                    </div>
                    <div class="input-wrap">
                        <label for="memberContent">자기소개</label>
                        <textarea name="memberContent" id="memberContent" class="input-form"></textarea>
                    </div>
                    <div class="input-wrap">
                        <input type="checkbox" name="all-agree" id="all-agree"><label for="all-agree">전체약관선택</label>
                        <div class="agree">
                            <input type="checkbox" name="agree1" id="agree1" class="checkbox"><label for="agree1">개인정보 처리 방침에 동의합니다.</label>
                            <div class="agree-content">
                                <p>개인정보 처리</p>
                                <p>
                                풋살데이트 개인정보 수집 및 이용 동의<br><br>
                                풋살데이트(이하 “회사”)은 개인정보보호법에 따라 이용자의 개인정보 보호 및 권익을 보호하고 개인정보와 관련한 이용자의 고충을 원활하게 처리할 수 있도록 다음과 같은 처리방침을 두고 있습니다.<br><br>
                                제 1 조 (수집하는 개인정보의 항목 및 수집방법)<br><br>
                                1) 수집하는 개인정보의 항목<br><br>
                                (1) 회사는 회원가입, 원활한 고객 상담, 각종 서비스의 제공을 위해 최초 회원가입 당시 아래와 같은 최소한의 개인정보를 필수항목으로 수집하고 있습니다.<br><br>
                                <회원가입><br>
                                - 필수항목 : 이름, 이메일, 비밀번호, 휴대폰 번호, 사진, 생년월일, 성별, 활동지역, CI(연계정보)<br><br>
                                (2) 서비스 이용과정이나 사업처리 과정에서 아래와 같은 정보들이 자동으로 생성되어 수집될 수 있습니다.<br>
                                - IP Address, 쿠키, 방문 일시, 서비스 이용 기록, 불량 이용 기록, 기기 정보<br><br>
                                (3) 풋살데이트 아이디를 이용한 부가 서비스 및 맞춤식 서비스 이용 또는 이벤트 응모 과정에서 해당 서비스의 이용자만 아래와 같은 정보들이 수집될 수 있습니다.<br>
                                - 개인정보 추가 수집에 대해 동의를 받는 경우<br><br>
                                2) 개인정보 수집방법<br>
                                회사는 다음과 같은 방법으로 개인정보를 수집합니다.<br><br>
                                (1) 모바일 회원가입 양식, 전화, 이메일<br><br>
                                (2) 생성정보 수집 도구를 통한 수집<br><br>
                                (3) 모바일 서비스의 특성상 단말기에 관한 정보(단말기 모델, 이동통신사 정보, 하드웨어 ID, 해시 처리한 단말기 번호, 서비스 이용에 대한 기본 통계 등)가 수집될 수 있습니다. 본 정보는 더 나은 서비스 제공 및 부정 이용 방지 등의 목적을 위해 단말기 식별/인증 등에 이용될 수 있습니다.<br><br>
                                (4) 단말기에 관한 정보 이외에 추가로 로그 정보, 서비스 이용기록, 네이버 애플리케이션 정보, 브라우저 정보 등이 수집될 수 있습니다.<br><br>
                                제 2 조 (개인정보의 수집 및 이용목적)<br><br>
                                1) 서비스 회원가입 및 관리<br>
                                회원 가입 의사 확인, 회원제 서비스 제공에 따른 본인 식별?인증, 회원자격 유지?관리, 제한적 본인 확인제 시행에 따른 본인확인, 서비스 부정이용 방지, 각종 고지?통지 등을 목적으로 개인정보를 처리합니다.<br><br>
                                2) 신규 서비스 개발 및 마케팅,광고에의 활용<br>
                                신규 서비스 개발 및 맞춤 서비스 제공, 통계학적 특성에 따른 서비스 제공 및 광고 게재, 서비스의 유효성 확인, 이벤트 정보 및 광고성 정보 제공 및 참여기회 제공, 접속빈도 파악, 회원의 서비스이용에 대한 통계 등을 목적으로 개인정보를 처리합니다. <br><br>
                                제 3 조 (개인정보의 공유 및 제공)<br><br>
                                회사는 이용자들의 개인정보를 “제 2 조. 개인정보의 수집목적 및 이용목적"에서 고지한 범위내에서 사용하며, 이용자의 사전 동의 없이는 동 범위를 초과하여 이용하거나 원칙적으로 이용자의 개인정보를 외부에 공개하지 않습니다. 다만, 아래의 경우에는 예외로 합니다.<br><br>
                                1) 이용자가 사전에 동의 한 경우<br><br>
                                2)법령의 규정에 의거하거나, 수사 목적으로 법령에 정해진 절차와 방법에 따라 수사기관의 요구가 있는 경우<br><br>
                                제 4 조 (개인정보의 보유 및 이용 기간)<br><br>
                                이용자의 개인정보는 원칙적으로 개인정보의 수집 및 이용목적이 달성되면 지체 없이 파기합니다. 단, 다음의 정보에 대해서는 아래의 보존 이유를 위해 명시한 기간 동안 보존합니다.<br><br>
                                1) 회사 내부 방침에 의한 정보보유 사유<br><br>
                                2) 부정이용기록(부정가입, 징계기록 등의 비정상적 서비스 이용기록)<br><br>
                                (1)보존 항목 : 휴대폰 번호, 이메일<br><br>
                                (2)보존 이유 : 부정 가입 및 이용 방지<br><br>
                                (3)보존 기간 : 1년<br>
                                ※ ‘부정이용기록’이란 부정 가입 및 운영원칙에 위배되는 게시글 작성 등으로 인해 회사로부터 이용제한 등을 당한 기록입니다.<br><br>
                                3)관련법령에 의한 정보보유 사유<br><br>
                                상법, 전자상거래 등에서의 소비자보호에 관한 법률 등 관계 법령의 규정에 의하여 보존할 필요가 있는 경우 회사는 관계 법령에서 정한 일정한 기간 동안 회원 정보를 보관합니다. 이 경우 회사는 보관하는 정보를 그 보관의 목적으로만 이용하며 보존 기간은 아래와 같습니다.<br><br>
                                (1) 계약 또는 청약철회 등에 관한 기록<br>
                                보존 이유 : 전자상거래 등에서의 소비자보호에 관한 법률<br>
                                보존 기간 : 5년<br><br>
                                (2) 대금결제 및 재화 등의 공급에 관한 기록<br>
                                보존 이유 : 전자상거래 등에서의 소비자보호에 관한 법률<br>
                                보존 기간 : 5년<br><br>
                                (3) 소비자의 불만 또는 분쟁처리에 관한 기록<br>
                                보존 이유 : 전자상거래 등에서의 소비자보호에 관한 법률<br>
                                보존 기간 : 3년<br><br>
                                (4) 웹사이트 방문기록<br>
                                보존 이유 : 통신 비밀 보호법<br>
                                보존 기간 : 3개월<br><br>
                                제 5 조 (개인정보 파기절차 및 방법)<br>
                                이용자의 개인정보는 원칙적으로 개인정보의 수집 및 이용목적이 달성되면 지체 없이 파기합니다.<br>
                                회사의 개인정보 파기절차 및 방법은 다음과 같습니다.<br><br>
                                1) 파기절차<br>
                                이용자가 회원가입 등을 위해 입력한 정보는 목적이 달성된 후 별도의 DB로 옮겨져(종이의 경우 별도의 서류함) 내부 방침 및 기타 관련 법령에 의한 정보보호 사유에 따라(보유 및 이용기간 참조) 일정 기간 저장된 후 파기됩니다. 이때, DB로 옮겨진 개인정보는 법률에 의한 경우가 아니고서는 보유되는 이외의 다른 목적으로 이용되지 않습니다.<br><br>
                                2) 파기기한<br>
                                이용자의 개인정보는 개인정보의 보유 기간이 경과된 경우에는 보유 기간의 종료일로부터 5일 이내에, 개인정보의 처리 목적 달성, 해당 서비스의 폐지, 사업의 종료 등 그 개인정보가 불필요하게 되었을 때는 개인정보의 처리가 불필요한 것으로 인정되는 날로부터 5일 이내에 그 개인정보를 파기합니다.<br><br>
                                3) 파기방법<br>
                                종이에 출력된 개인정보는 분쇄기로 분쇄하거나 소각을 통하여 파기합니다.<br>
                                전자적 파일 형태로 저장된 개인정보는 기록을 재생할 수 없는 기술적 방법을 사용하여 삭제합니다.<br><br>
                                제 6 조 (개인정보 자동 수집 장치의 설치/운영 및 거부에 관한 사항)<br><br>
                                1) 쿠키란?<br>
                                (1) 회사는 개인화되고 맞춤화된 서비스를 제공하기 위해서 이용자의 정보를 저장하고 수시로 불러오는 '쿠키(cookie)'를 사용합니다.<br>
                                (2) 쿠키는 웹사이트를 운영하는데 이용되는 서버가 이용자의 브라우저에게 보내는 아주 작은 텍스트 파일로 이용자 컴퓨터의 하드디스크에 저장됩니다. 이후 이용자가 웹 사이트에 방문할 경우 웹 사이트 서버는 이용자의 하드 디스크에 저장된 쿠키의 내용을 읽어 이용자의 환경설정을 유지하고 맞춤화된 서비스를 제공하기 위해 이용됩니다.<br>
                                (3) 쿠키는 개인을 식별하는 정보를 자동적/능동적으로 수집하지 않으며, 이용자는 언제든지 이러한 쿠키의 저장을 거부하거나 삭제할 수 있습니다.<br><br>
                                2) 회사의 쿠키 사용 목적<br>
                                이용자들이 방문한 풋살데이트 서비스 페이지에 대한 방문 및 이용형태, 검색내용, 이용자 규모 등을 파악하여 이용자에게 광고를 포함한 최적화된 맞춤형 정보를 제공하기 위해 사용합니다. 단, 모바일 기기에서의 쿠키 세션은 기기 특성 및 이용자 편의를 고려하여 일반 PC에서의 쿠키 세션보다 그 기간이 더 길게 유지될 수 있습니다.<br><br>
                                3) 쿠키의 설치/운영 및 거부<br>
                                - 이용자는 쿠키 설치에 대한 선택권을 가지고 있으며, 모바일 기기에서도 웹브라우저 설정 기능에서 쿠키 허용 여부를 선택할 수 있습니다. 모바일 기기의 운영체제 및 웹 브라우저 종류에 따라 다소 상이할 수 있지만, 대부분의 경우 모바일 웹브라우저의 환경 설정을 통해 쿠키허용 여부를 결정하거나, 기존의 쿠키 일체를 삭제할 수 있습니다. 다만 쿠키의 저장을 거부할 경우, 로그인이 필요한 일부 서비스의 이용에 불편함이 있을 수 있습니다.<br><br>
                                제 7 조 (개인정보의 기술적/관리적 보호 대책)<br>
                                회사는 이용자들의 개인정보를 취급하면서 개인정보가 분실, 도난, 누출, 변조 또는 훼손되지 않도록 안전성 확보를 위하여 다음과 같은 기술적/관리적 대책을 마련하고 있습니다.<br><br>
                                1) 개인정보 취급 직원의 최소화 및 교육<br>
                                개인정보를 취급하는 직원을 지정하고 담당자에 한정시켜 최소화하여 개인정보를 관리하는 대책을 시행하고 있습니다.<br><br>
                                2) 내부관리계획의 수립 및 시행<br>
                                개인정보의 안전한 처리를 위하여 내부관리계획을 수립하고 시행하고 있습니다.<br><br>
                                3) 개인정보의 암호화<br>
                                이용자의 개인정보는 비밀번호의 경우 암호화 되어 저장 및 관리되고 있어, 본인만이 알 수 있으며 중요한 데이터는 파일 및 전송 데이터를 암호화하거나 파일 잠금 기능을 사용하는 등의 별도 보안 기능을 사용하고 있습니다.<br><br>
                                4) 해킹 등에 대비한 기술적 대책<br>
                                풋살데이트는 해킹이나 컴퓨터 바이러스 등에 의한 개인정보 유출 및 훼손을 막기 위하여 보안프로그램을 설치하고 주기적인 갱신?점검을 하며 외부로부터 접근이 통제된 구역에 시스템을 설치하고 기술적/물리적으로 감시 및 차단하고 있습니다.<br><br>
                                5) 개인정보에 대한 접근 제한<br>
                                개인정보를 처리하는 데이터베이스시스템에 대한 접근 권한의 부여,변경,말소를 통하여 개인정보에 대한 접근통제를 위하여 필요한 조치를 하고 있으며 침입차단시스템을 이용하여 외부로부터의 무단 접근을 통제하고 있습니다.<br><br>
                                6) 접속기록의 보관 및 위변조 방지<br>
                                개인정보처리시스템에 접속한 기록을 최소 6개월 이상 보관, 관리하고 있으며, 접속 기록이 위변조 및 도난, 분실되지 않도록 보안기능 사용하고 있습니다.<br><br>
                                7) 문서보안을 위한 잠금장치 사용 및 비인가자 출입 통제<br>
                                개인정보가 포함된 서류, 보조 저장매체 등을 잠금장치가 있는 안전한 장소에 보관하고 이에 대해 출입통제 절차를 수립, 운영하고 있습니다.<br><br>
                                단, 회사가 개인정보보호 의무를 다 하였음에도 불구하고 이용자 본인의 부주의나 회사가 관리하지 않는 영역에서의 사고 등 회사의 귀책에 기인하지 않은 손해에 대해서는 회사는 책임을 지지 않습니다.<br><br>
                                제 8 조 (개인정보 관리책임자의 연락처)<br>
                                귀하께서는 회사의 서비스를 이용하시며 발생하는 모든 개인정보보호 관련 민원을 개인정보 관리책임자 혹은 담당 부서로 신고하실 수 있습니다. 회사는 이용자들의 신고사항에 대해 신속하게 충분한 답변을 드릴 것입니다.<br><br>
                                개인정보 관리책임자<br>
                                성명 : 김건형, 신혜빈, 안진배, 이민호, 이화정<br>
                                이메일 : admin@futsaldate.com<br>
                                직책 : 대표이사겸 전무이사겸 상무이사겸 본부장겸 팀장겸 팀원<br><br>
                                개인정보침해에 대한 신고나 상담이 필요하신 경우에는 아래 기관에 문의하시기 바랍니다.<br><br>
                                (1)개인정보침해신고센터 (privacy.kisa.or.kr / 국번없이 118)<br><br>
                                (2)대검찰청 사이버범죄수사단 (www.spo.go.kr / 02-3480-3571)<br><br>
                                (3)경찰청 사이버안전국 (www.ctrc.go.kr / 국번없이 182)<br><br>
                                제 9 조 (고지의 의무)<br>
                                현 개인정보취급방침 내용 추가, 삭제 및 수정이 있을 시에는 개정 최소 7일전부터 홈페이지의 '공지사항'을 통해 고지할 것입니다. 다만, 개인정보의 수집 및 활용, 제3자 제공 등과 같이 이용자 권리의 중요한 변경이 있을 경우에는 최소 30일 전에 고지합니다.<br><br>
                                1)공고일자 : 2023년 03월 05일<br>
                                2)시행일자 : 2023년 03월 05일<br>
                                3)변경일자 : 2023년 03월 05일<br>
                                </p>    
                            </div>
                        </div>
                        <div class="agree">
                            <input type="checkbox" name="agree2" id="agree2" class="checkbox"><label for="agree2">서비스 이용약관에 동의합니다.</label>
                            <div class="agree-content">
                                <p>서비스 이용약관</p>
                                <p>
                                    풋살데이트 서비스 이용약관<br>
                                    최종 수정일: 2022년 03월 05일<br><br>
                                    풋살데이트 어플리케이션 다운로드, 자사 웹사이트 및 서비스의 사용에 앞서 아래 이용 약관을 반드시 검토하시기 바랍니다. 풋살데이트 사용약관 (“이용 약관”)은 웹사이트와 관련 소프트웨어 어플리케이션 및 플랫폼 (풋살데이트 서비스로 통칭)의 소유주이자 운영자인 (“저희”)와 풋살데이트 서비스 사용자 간의 계약으로 법적 구속력을 갖습니다. 사용자는 어떤 방식으로든 풋살데이트 서비스를 사용함으로써 (풋살데이트 탐색, 풋살데이트 모바일 어플리케이션 및 온라인 플랫폼 사용 등) 본 이용 약관 및 풋살데이트 개인정보보호정책에 동의한 것으로 간주합니다. 개인정보보호정책은 개인정보 취급방침 메뉴에서 열람 가능합니다. 약관에 동의하지 않는 경우 풋살데이트 서비스를 이용할 수 없습니다.<br>
                                    이용 약관은 풋살데이트 서비스의 모든 사용자에게 적용됩니다. 단순히 웹사이트를 탐색하는 자와 계정을 등록하는 자 모두가 사용자에 포함됩니다. 단 이용 약관의 각 부분은 각 사용자에게 서로 다른 방식으로 적용되므로, 본 이용 약관을 주의 깊게 검토하시기 바랍니다.<br><br>
                                    풋살데이트 서비스 개요<br><br>
                                    제 1장 총칙<br>
                                    제 1조(목적)<br>
                                    이 약관은 전기 통신 사업 법령 및 정보 통신망 이용 촉진 등에 관한 법령에 의하여 그라운드모바일(이하 “회라”라 한다)가 제공하는 홈페이지 서비스(이하 “서비스”라 한다)의 이용조건 및 절차에 관한 사항을 규정함을 목적으로 합니다.<br><br>
                                    제 2조(약관의 공지 및 준용)<br>
                                    ① 이 약관의 내용은 서비스 화면에 게시하거나 기타의 방법으로 회원에게 공지함으로써 효력을 발생합니다.<br>
                                    ② 회사는 이 약관을 임의로 변경할 수 있으며, 변경된 약관은 제1항과 같은 방법으로 공지함으로써 효력을 발생합니다.<br><br>
                                    제 3조(약관 외 준칙)<br>
                                    이 약관에 명시되지 않은 사항은 전기 통신 기본법, 전기 통신 사업법, 정보 통신망 이용촉진등에 관한 법률 및 기타 관련법령의 규정에 의합니다.<br><br>
                                    제 4조(용어의 정의)<br>
                                    이 약관에서 사용하는 용어의 정의는 다음과 같습니다.<br>
                                    - 회원 : [회원]이라 함은 [이용자] 중 [풋살데이트 계정]에 등록하고 [풋살데이트]에 개인정보를 제공하여 회원등록을 한 자로서, [풋살데이트]의 정보를 지속적으로 제공받으며, “서비스”를 계속적으로 이용할 수 있는 자를 말합니다.<br>
                                    - 아이디(ID) : [아이디(ID)]라 함은 “회원”의 식별과 “서비스” 이용을 위하여 “회원”이 정하고 [풋살데이트]가 승인하는 문자와 숫자의 조합을 의미합니다.<br>
                                    - 비밀번호 : [비밀번호]라 함은 “회원”이 부여받은 아이디(ID)와 일치되는 “회원”임을 확인하고 비밀보호를 위해 “회원” 자신이 정한 문자 또는 숫자의 조합을 의미합니다.<br>
                                    - 운영자 혹은 관리자 : 서비스의 전박적인 관리와 원활한 운영을 위하여 회사에서 선정한 사람<br>
                                    - 해지 : 회사 또는 회원이 서비스 개통 후 이용계약을 해약하는 것<br><br>
                                    제 2장 서비스 이용계약<br>
                                    제 5조(이용계약의 성립)<br>
                                    - “이용약관에 동의하십니까?” 라는 이용신청시의 물음에 회원이 “예” 버튼을 누르면 이 약관에 동의하는 것으로 간주됩니다.<br>
                                    - 이용계약은 회원의 이용신청에 대하여 회사가 심사 후 승낙함으로써 성립합니다.<br><br>
                                    제 6조(이용신청)<br>
                                    - 이용신청은 온라인으로 회사 소정의 가입신청 양식에서 요구하는 사항을 기록하여 신청합니다.<br>
                                    - 온라인 가입신청 양식에 기재하는 모든 회원 정보는 실제 데이터인 것으로 간주하며, 실명이나 실제 정보를 입력하지 않은 사용자는 법적인 보호를 받을 수 없으며, 서비스 사용의 제한을 받을 수 있습니다.<br><br>
                                    제 7조(회원정보 사용에 대한 동의)<br>
                                    - 회원의 개인 정보에 대해서는 회사의 개인정보 보호정책이 적용됩니다.<br>
                                    - 회사가 제 6조에 따라 신청서에 기재를 요구하는 회원의 개인정보는 본 이용계약의 이행과 본 이용계약상의 서비스제공을 위한 목적으로 이용합니다.<br>
                                    - 회원이 회사 및 회사와 제휴한 서비스들을 편리하게 이용할 수 있도록 하기 위해 회원 정보는 회사와 제휴한 업체에 제공될 수 있습니다. 단, 회사는 회원 정보 제공 이전에 제휴 업체, 제공 목적, 제공할 회원 정보의 내용 등을 사전에 공지하고 회원의 동의를 얻어야 합니다.<br>
                                    - 회원은 회원정보 수정을 통해 언제든지 개인 정보에 대한 열람 및 수정을 할 수 있습니다.<br>
                                    - 회원이 이용신청서에 회원정보를 기재하고, 회사의 본 약관에 따라 이용신청을 하는 것은 회사가 본 약관에 따라 이용신청서에 기재된 회원정보를 수집, 이용 및 제공하는 것에 동의하는 것으로 간주됩니다.<br><br>
                                    제 8조(이용신청의 승낙)<br>
                                    - 회사는 회원이 제 6조에서 정한 모든 사항을 정확히 기재하여 이용신청을 하였을 때 제2호, 제3호의 경우를 예외로 하여 승낙할 수 있습니다.<br>
                                    - 회사는 다음 각 호의 1에 해당하는 이용신청에 대하여는 승낙을 유보할 수 있습니다.<br>
                                    ㉮ 설비에 여유가 없는 경우<br>
                                    ㉯ 기술상 지장이 있는 경우<br>
                                    ㉰ 기타 회사의 사정상 이용승낙이 곤란한 경우<br>
                                    ③ 회사는 다음 각 호의 1에 해당하는 이용신청에 대하여는 이를 승낙하지 아니 할 수 있습니다.<br>
                                    ㉮ 이름이 실명이 아닌 경우<br>
                                    ㉯ 다른 사람의 명의를 사용하여 신청한 경우<br>
                                    ㉰ 이용신청 시 필요내용을 허위로 기재하여 신청한 경우<br>
                                    ㉱ 사회의 안녕질서 또는 미풍양속을 저해할 목적으로 신청한 경우<br>
                                    ㉲ 기타 회사가 정한 이용신청요건이 미비되었을 때<br><br>
                                    제 9조(계약사항의 변경)<br>
                                    회원은 이용신청 시 기재한 사항이 변경되었을 경우에는 온라인으로 수정을 해야하고, 미변경으로 인하여 발생되는 문제의 책임은 회원에게 있습니다.<br><br>
                                    제 3장 계약당사자의 의무<br>
                                    제 10조(회사의 의무)<br>
                                    ① 회사는 서비스 제공과 관련해서 알고 있는 회원의 신상정보를 본인의 승낙없이 제 3자에게 누설, 배포하지 않습니다. 단, 전기통신기본법 등 법률의 규정에 의해 국가기관의 요구가 있는 경우, 범죄에 대한 수사상의 목적이 있거나 정보통신윤리 위원회의 요청이 있는 경우 또는 기타 관계법령에서 정한 절차에 따른 요청이 있는 경우에는 그러하지 않습니다.<br>
                                    ② 1항의 범위내에서, 회사는 업무와 관련하여 회원 전체 또는 일부의 개인정보에 관한 통계 자료를 작성하여 이를 사용할 수 있고, 서비스를 통하여 회원의 컴퓨터에 쿠키를 전송할 수 있습니다. 이 경우 회원은 쿠키의 수신을 거부하거나 쿠키의 수신에 대하여 경고하도록 사용하는 컴퓨터의 브라우져의 설정을 변경할 수 있습니다.<br><br>
                                    제 11조(회원의 의무)<br>
                                    ① 회원은 서비스를 이용할 때 다음 각 호의 행위를 하지 않아야 합니다.<br>
                                    ㉮ 다른 회원의 ID를 부정하게 사용하는 행위<br>
                                    ㉯ 서비스에서 얻은 정보를 회사의 사전승낙 없이 회원의 이용이외의 목적으로 복제하거나 이를 출판 및 방송 등에 사용하거나 제3자에게 제공하는 행위<br>
                                    ㉰ 회사의 저작권, 제3자의 저작권 등 기타 권리를 침해하는 행위<br>
                                    ㉱ 공공질서 및 미풍양속에 위반되는 내용의 정보, 문장, 도형 등을 타인에게 유포하는 행위<br>
                                    ㉲ 범죄와 결부된다고 객관적으로 판단되는 행위<br>
                                    ㉳ 기타 관계법령에 위배되는 행위<br>
                                    ② 회원은 이 약관에서 규정하는 사항과 서비스 이용안내 또는 주의사항을 준수하여야 합니다.<br>
                                    ③ 회원은 내용별로 회사가 서비스 공지사항에 게시하거나 별도로 공지한 이용제한 사항을 준수하여야 합니다.<br>
                                    ④ 회원은 회사의 사전 승낙없이는 서비스를 이용하여 영업활동을 할 수 없으며, 영업활동의 결과와 회원이 약관에 위반한 영업활동을 이용하여 발생한 결과에 대하여 회사는 책임을지지 않습니다. 회원은 이와 같은 영업활동에 대하여 회사에 대하여 손해배상의무를 집니다.<br>
                                    ⑤ 회원은 회사의 명시적인 동의가 없는 한 서비스의 이용권한, 기타 이용계약상 지위를 타인에게 양도, 증여할 수 없으며, 이를 담보로 제공할 수 없습니다.<br><br>
                                    제 4장 서비스 이용<br>
                                    제 12조(회원 아이디(ID)와 비밀번호 관리에 대한 회원의 의무)<br>
                                    ① 아이디(ID)와 비밀번호에 관한 모든 관리책임은 회원에게 있습니다. 회원에게 부여된 아이디(ID)와 비밀번호의 관리소홀, 부정사용에 의하여 발생하는 모든 결과에 대한 책임은 회원에게 있습니다.<br>
                                    ② 자신의 아이디(ID)가 부정하게 사용된 경우 회원은 반드시 회사에 그 사실을 통보해야 합니다.<br><br>
                                    제 13조(정보의 제공)<br>
                                    회사는 회원이 서비스 이용 중 필요가 있다고 인정되는 다양한 정보에 대해서 전자우편이나 서신우편 등의 방법으로 회원에게 제공할 수 있으며, 회원은 원치 않을 경우 가입신청메뉴와 회원정보수정 메뉴에서 정보 수신거부를 할 수 있습니다.<br><br>
                                    제 14조(회원의 게시물)<br>
                                    회사는 회원이 게시하거나 등록하는 서비스내의 내용물이 다음 각 호의 1에 해당한다고 판단되는 경우에 사전통지 없이 삭제할 수 있습니다.<br>
                                    ① 다른 회원 또는 제 3자를 비방하거나 중상모략으로 명예를 손상시키는 내용인 경우<br>
                                    ② 공공질서 및 미풍양속에 위반되는 내용인 경우<br>
                                    ③ 범죄적 행위에 결부된다고 인정되는 내용일 경우<br>
                                    ④ 회사의 저작권, 제 3자의 저작권 등 기타 권리를 침해하는 내용인 경우<br>
                                    ⑤ 회사에서 규정한 게시기간을 초과한 경우<br>
                                    ⑥ 회원이 자신의 홈페이지와 게시판에 음란물을 게재하거나 음란사이트를 링크하는 경우<br>
                                    ⑦ 기타 관계법령에 위반된다고 판단하는 경우<br><br>
                                    제 15조(게시물의 저작권)<br>
                                    서비스에 게재된 자료에 대한 권리는 다음 각 호와 같습니다.<br>
                                    ① 게시물에 대한 권리와 책임은 게시자에게 있으며 회사는 게시자의 동의 없이는 이를 서비스내 게재 이외에 영리적 목적으로 사용하지 않습니다. 단, 비영리적인 경우에는 그러하지 아니하며 또한 회사는 서비스내의 게재권을 갖습니다.<br>
                                    ② 회원은 서비스를 이용하여 얻은 정보를 가공, 판매하는 행위 등 서비스에 게재된 자료를 상업적으로 사용할 수 없습니다.<br><br>
                                    제 16조(서비스 이용기간)<br>
                                    ① 서비스의 이용은 회사의 업무상 또는 기술상 특별한 지장이 없는 한 연중무휴 1일 24시간을 원칙으로 합니다. 다만 정기 점검 등의 필요로 회사가 정한 날이나 시간은 그러하지 않습니다.<br>
                                    ② 회사는 서비스를 일정범위로 분할하여 각 범위별로 이용가능 시간을 별도로 정할 수 있습니다. 이 경우 그 내용을 사전에 공지합니다.<br><br>
                                    제 17조(서비스 이용 책임)<br>
                                    회원은 회사에서 권한 있는 사원이 서명한 명시적인 서면에 구체적으로 허용한 경우를 제외하고는 서비스를 이용하여 불법상품을 판매하는 영업활동을 할 수 없으며, 특히 해킹, 돈벌기 광고, 음란사이트를 통한 상업행위, 상용S/W 불법배포 등을 할 수 없습니다. 이를 어기고 발생한 영업활동의 결과 및 손실, 관계기관에 의한 구속 등 법적 조치등에 관해서는 회사가 책임을지지 않습니다.<br><br>
                                    제 18조(서비스 제공의 중지)<br>
                                    ① 회사는 다음 각 호에 해당하는 경우 서비스 제공을 중지할 수 있습니다.<br>
                                    가. 서비스용 설비의 보수 등 공사로 인한 부득이한 경우<br>
                                    나. 전기통신사업법에 규정된 기간통신사업자가 전기통신 서비스를 중지했을 경우<br>
                                    다. 기타 불가항력적 사유가 있는 경우<br>
                                    ② 회사는 국가비상사태, 정전, 서비스 설비의 장애 또는 서비스 이용의 폭주 등으로 정상적인 서비스 이용에 지장이 있는 때에는 서비스의 전부 또는 일부를 제한하거나 정지할 수 있습니다.<br><br>
                                    제 5장 계약해지 및 이용제한<br>
                                    제 19조(계약해지 및 이용제한)① 회원이 이용계약을 해지하고자 하는 때에는 회원 본인이 온라인을 통해 회사에 해지 신청을 하여야 합니다.<br>
                                    ② 회사는 회원이 다음 각 호의 1에 해당하는 행위를 하였을 경우 사전통지 없이 이용계약을 해지하거나 또는 기간을 정하여 서비스 이용을 중지할 수 있습니다.<br>
                                    가. 타인의 서비스 ID 및 비밀번호를 도용한 경우<br>
                                    나. 서비스 운영을 고의로 방해한 경우<br>
                                    다. 가입한 이름이 실명이 아닌 경우<br>
                                    라. 같은 사용자가 다른 ID로 이중등록을 한 경우<br>
                                    마. 공공질서 및 미풍양속에 저해되는 내용을 고의로 유포시킨 경우<br>
                                    바. 회원이 국익 또는 사회적 공익을 저해할 목적으로 서비스 이용을 계획 또는 실행하는 경우<br>
                                    사. 타인의 명예를 손상시키거나 불이익을 주는 행위를 한 경우<br>
                                    아. 서비스의 안정적 운영을 방해할 목적으로 다량의 정보를 전송하거나 광고성 정보를 전송하는 경우<br>
                                    자. 정보통신설비의 오작동이나 정보 등의 파괴를 유발시키는 컴퓨터 바이러스 프로그램 등을 유포하는 경우<br>
                                    차. 회사, 다른 회원 또는 제3자의 지적재산권을 침해하는 경우<br>
                                    카. 정보통신윤리위원회 등 외부기관의 시정요구가 있거나 불법선거운동과 관련하여 선거관리위원회의 유권해석을 받은 경우<br>
                                    타. 타인의 개인정보, 이용자 ID 및 비밀번호를 부정하게 사용하는 경우<br>
                                    파. 회사의 서비스 정보를 이용하여 얻은 정보를 회사의 사전 승낙없이 복제 또는 유통시키거나 상업적으로 이용하는 경우<br>
                                    하. 회원이 자신의 홈페이지와 게시판에 음란물을 게재하거나 음란사이트 링크하는 경우<br>
                                    거. 본 약관을 포함하여 기타 회사가 정한 이용조건에 위반한 경우<br>
                                    너. 장기간 휴면 가입자에 대하여 통지할 경우 그 통지 기간 내에도 서비스 이용에 대한 의사표현을 하지 않은 경우 전 항 규정에 의해 이용제한을 하고자 할 경우에는 제한의 종류 및 기간 등 구체적 기준은 회사의 공지, 서비스안내, 세부규칙 등에 별도로 정하는 바에 의한다.<br><br>
                                    제 20조(이용제한의 해제 절차)<br>
                                    ① 회사는 이용제한을 하고자 하는 경우에는 그 사유, 일시 및 기간을 정하여 서면 또는 전화 등의 방법을 이용하여 해당 회원 또는 대리인에게 통지합니다.<br>
                                    ② 다만, 회사는 긴급하게 이용을 중지해야 할 필요가 있다고 인정하는 경우에는 전항의 과정없이 서비스 이용을 제한할 수 있습니다.<br>
                                    ③ 제 19조 2항 규정에 의하여 서비스 이용중지를 통지 받은 회원 또는 그 대리인은 이용중지에 대하여 이의가 있을 경우 이의 신청을 할 수 있습니다.<br>
                                    ④ 회사는 이용중지 기간 중에 그 이용중지 사유가 해소된 것이 확인된 경우에 한하여 이용중지 조치를 즉시 해제합니다.<br><br>
                                    제 6장 손해배상 등<br>
                                    제 21조(손해배상)<br>
                                    회사는 서비스 요금이 무료인 동안의 서비스 이용과 관련하여 회사의 고의, 과실에 의한 것이 아닌 한 회원에게 발생한 어떠한 손해에 관하여도 책임을 지지 않습니다.<br><br>
                                    제 22조(면책조항)<br>
                                    ① 회사는 천재지변 또는 이에 준하는 불가항력으로 인하여 서비스를 제공할 수 없는 경우에는 서비스 제공에 관한 책임이 면제됩니다.<br>
                                    ② 회사는 회원의 귀책사유로 인한 서비스 이용의 장애에 대하여 책임을 지지 않습니다.<br>
                                    ③ 회사는 회원이 서비스를 이용하여 기대하는 수익을 상실한 것에 대하여 책임을 지지 않으며, 그 밖에 서비스를 통하여 얻은 자료로 인한 손해에 관하여 책임을 지지 않습니다.<br>
                                    ④ 회사는 회원이 서비스에 게재한 정보, 자료, 사실의 신뢰도, 정확성 등 내용에 관하여는 책임을 지지 않습니다.<br><br>
                                    제 23조(법적 책임 부인)<br>
                                    풋살데이트 서비스 상에서 또는 이를 통해 사용자에게 전달되는 정보, 추천 및 서비스는 일반 정보 제공만을 목적으로 하며 자문이 아닙니다. 풋살데이트 서비스에 대한 지속적, 연속적 접근을 보장하지 않습니다.<br>
                                    그라운드모바일은 풋살데이트 서비스를 통해 접근 가능한 정보의 진실성과 정확성을 유지하기 위해 노력하고 있으나, 해당 정보의 진실성, 완전성, 정확성을 보장하지 않습니다.<br>
                                    다른 사용자 및 제 3자가 그라운드모바일이 모르게 풋살데이트 서비스에 무단으로 추가, 삭제, 변경을 가할 가능성이 있습니다.<br>
                                    그라운드모바일은 풋살데이트 서비스(웹사이트와 어플리케이션 포함)( 및 그 컨텐츠)에 오류, 악성코드, 바이러스가 없을 것임을 보장하지 않습니다.<br><br>
                                    제 24조(관할법원)<br>
                                    요금 등 서비스 이용으로 발생한 분쟁에 대해 소송이 제기될 경우 회사의 본사 소재지를 관할하는 법원을 전속 관할법원으로 합니다.<br><br>
                                    제 25조(소셜 경기 환불 규정)<br>
                                    ①  2일 전 : 100% 환급(송금 수수료 500원 발생)<br>
                                    ②  1일 전 : 80% 환급(송금 수수료 500원 발생)<br>
                                    ③  당일 3시간 전 : 20% 환급(송금 수수료 500원 발생)<br>
                                    ④  당일 3시간 미만 : 0% 환급<br>
                                    * 우천시 최소 경기 시작 1시간 30분 전에 기상청 예보에 해당 경기장 주소지 기준 ‘호우 경보’ 이상 시 경기 취소가 되며, 참가비 전액 환불<br>
                                    * 경기 도중 우천으로 경기가 중단되는 경우 부분 환불<br><br>
                                    [부칙]<br>
                                    (시행일) 이 약관은 2023년 3월 05일부터 시행합니다.<br>
                                </p>
                            </div>
                        </div>
                    </div>
                    <button type="submit" class="btn bc1 bs4" >회원가입</button>
                </form>
            </div>
        </div>
        <script>
        function loadImg(f){
           if(f.files.length !=0 && f.files[0] !=0){
                const reader = new FileReader();
                reader.readAsDataURL(f.files[0]);
                reader.onload = function(e){
                    $("#img-view").attr("src",e.target.result);
                }
           }else{
                $("#img-view").attr("src","img/profile.png");
                }
           }
    	
        $("#memberPw").on("focus",function(){
    		const inputType = $(this).attr("type");
            if(inputType === "text"){
                $(this).attr("type","password");
            }
        });
        $("#memberPwRe").on("focus",function(){
    		const inputType = $(this).attr("type");
            if(inputType === "text"){
                $(this).attr("type","password");
            }
    	});
        $("#memberPw").on("keyup",function(){
            const pw = $(this).val();
            const regExp = /^[a-z0-9]{8,16}$/;
            if(regExp.test(pw)){
                $("#msg1").text("비밀번호가 적합합니다.");
                $("#msg1").css("color","green");
                $(this).css("border","1px solid green");
            }else{
                $("#msg1").text("비밀번호가 적합하지 않습니다.");
                $("#msg1").css("color","red");
                $(this).css("border","1px solid red");
            }
        });
        $("#memberPwRe").on("change",function(){
            const pw = $("#memberPw").val();
            const pwRe = $(this).val();
            if(pw == pwRe){
                $("#msg2").text("비밀번호가 일치합니다.");
                $("#msg2").css("color","green");
                $(this).css("border","1px solid green");
            }else{
                $("#msg2").text("비밀번호가 일치하지 않습니다.");
                $("#msg2").css("color","red");
                $(this).css("border","1px solid red");
            }
        });
        
        function loadImg(f){
            if(f.files.length !=0 && f.files[0] !=0){
                const reader = new FileReader();
                reader.readAsDataURL(f.files[0]);
                reader.onload = function(e){
                    $("#img-view").attr("src",e.target.result);
                }
            }else{
                $("#img-view").attr("src","img/profile.png");
            }
        }

        $("#memberId").on("keyup",function(){
            const memberId = $(this).val();
            $.ajax({
                url : "/ajaxCheckId.do",
                type : "get",
                data : {memberId, memberId},
                success : function(data){
                    if(data == "1"){
                        $("#ajaxCheckId").text("이미 사용중인 아이디입니다.");
                        $("#ajaxCheckId").css("color","red");
                        $("#memberId").css("border","1px solid red");
                    }else if(data == "0"){
                        $("#ajaxCheckId").text("사용가능한 아이디입니다.");
                        $("#ajaxCheckId").css("color","green");
                        $("#memberId").css("border","1px solid green");
                    }
                }
            })
        });
        $("#mailSel").on("change",function(){
            const selMail = $(this).val();
                $("#memberMail2").val(selMail);
        });
        $("#all-agree").on("change",function(){
            $(".checkbox").prop("checked",$(this).prop("checked"));
        });
        
        let mailCode;
		$("#sendBtn").on("click",function(){
			const email1 = $("#memberMail1").val();
			const email2 = $("#memberMail2").val();
			const email = email1+"@"+email2;
			
			$.ajax({
				url : "/sendMail.do",
				data : {email : email},
				type : "post",
				success : function(data){
					
					if(data == "null"){
						alert("이메일 주소를 올바르지 않습니다.")
					}else{
						mailCode = data;
						$("#auth").slideDown();
						authTime();
					}
				},
				error : function(){
					console.log("에러발생");
				}
			});
			
		});
		let intervalId;
		function authTime(){
			$("#timeZone").html("<span id='min'>3</span> : <span id='sec'>00</span>");
			
			intervalId = window.setInterval(function(){
				timeCount();
			},1000);
		}
		
		function timeCount(){
			const min = $("#min").text();
			const sec = $("#sec").text();
			
			if(sec == "00"){
				if(min != "0"){
					const newMin = Number(min)-1;
					$("#min").text(newMin);
					$("#sec").text(59);		
				}else{
					window.clearInterval(intervalId);
					mailCode = null;
					$("#authMsg").text("인증시간 만료");
					$("#authMsg").css("color","red");
				}
			}else{
				const newSec = Number(sec)-1;
				if(newSec <10){
					$("#sec").text("0"+newSec);
				}else{
					$("#sec").text(newSec);
				}
			}
		}
		
		$("#authBtn").on("click",function(){
			if(mailCode == null){
				$("#authMsg").text("인증시간 만료");
				$("#authMsg").css("color","red");
			}else{
				
				const authCode = $("#authCode").val();
				
				if(authCode == mailCode){
					$("#authCode").prop("readonly",true);
					$("#authMsg").text("인증완료");
					$("#authMsg").css("color","blue");
					clearInterval(intervalId);
				}else{
					$("#authMsg").text("인증실패");
					$("#authMsg").css("color","red");
				}
			}
		});
        </script>
        <%@ include file="/WEB-INF/views/common/footer.jsp" %>
	   </body>
</html>