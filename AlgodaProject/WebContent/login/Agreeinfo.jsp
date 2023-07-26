<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>알고다 약관동의</title>


  
<style>

*{margin: 0;padding: 0; box-sizing: border-box}
body{background-color: #f7f7f7;}
ul>li{list-style: none}
a{text-decoration: none;}
.clearfix::after{content: "";display: block;clear: both;}
#agreeForm{width: 800px; height:600px; margin: 0 auto;}
ul.join_box{border: 1px solid #ddd;background-color: #fff;}
.checkBox,.checkBox>ul{position: relative;}
.checkBox>ul>li{float: left;}
.checkBox>ul>li:first-child{width: 85%;padding: 15px;font-weight: 600;color: #888;}
.checkBox>ul>li:nth-child(2){position: absolute;top: 50%;right: 30px;margin-top: -12px;}
.checkBox textarea{width: 96%;height: 90px; margin: 0 2%;background-color: #f7f7f7;color: #888; border: none;}
.footBtwrap{margin-top: 15px;}
.footBtwrap>li{float: left;width: 50%;height: 60px;}
.footBtwrap>li>button{display: block; width: 100%;height: 100%; font-size: 20px;text-align: center;line-height: 60px;}
.fpmgBt1{background-color: #53eba6;color:#fff}
.fpmgBt2{background-color: #53eba6;color: #fff}


</style>
</head>
<body>
<!--  http://localhost:9997/Algoda/login/Memberjoin.do-->
<!--  http://localhost:9997/Algoda/Memberjoin.do-->
  <form name="frm" id="agreeForm" method="get">
  
    <ul class="join_box">
        <li class="checkBox check01">
            <ul class="clearfix">
                <li>서비스 이용약관, 개인정보 처리방침,
                                    개인 정보 처리 위탁 , 마케팅 정보 제공
                                     에 모두 동의합니다.</li>
                <li class="checkAllBtn">
                    <input type="checkbox" name="chkAll" id="chkAll" class="chkAll" >
                </li>
            </ul>
        </li>
       
        <li class="checkBox check02">
            <ul class="clearfix">
                <li>서비스 이용약관 동의(필수)</li>
                <li class="checkBtn">
                    <input type="checkbox" name="chk" class="chk"> 
                </li>
            </ul>
            <textarea name="" id="">제6조(회원가입) 
  ① 이용자는 “알고다”이 정한 가입 양식에 따라 회원정보를 기입한 후 이 약관에 동의한다는 의사표시를 함으로서 회원가입을 신청합니다.

  ② “알고다”은 제1항과 같이 회원으로 가입할 것을 신청한 이용자 중 다음 각 호에 해당하지 않는 한 회원으로 등록합니다.

    1. 가입신청자가 이 약관 제7조제3항에 의하여 이전에 회원자격을 상실한 적이 있는 경우, 다만 제7조제3항에 의한 회원자격 상실 후 3년이 경과한 자로서 “알고다”의 회원재가입 승낙을 얻은 경우에는 예외로 합니다.
    2. 등록 내용에 허위, 기재누락, 오기가 있는 경우
    3. 기타 회원으로 등록하는 것이 “알고다”의 기술상 현저히 지장이 있다고 판단되는 경우

  ③ 회원가입계약의 성립 시기는 "알고다"”의 승낙이 회원에게 도달한 시점으로 합니다.

  ④ 회원은 회원가입 시 등록한 사항에 변경이 있는 경우, 상당한 기간 이내에 “알고다”에 대하여 회원정보 수정 등의 방법으로 그 변경사항을 알려야 합니다.
            
</textarea>
        </li>
        <li class="checkBox check03">
            <ul class="clearfix">
                <li>개인정보 처리방침 동의(필수)</li>
                <li class="checkBtn">
                    <input type="checkbox" name="chk" class="chk">
                </li>
            </ul>

            <textarea name="" id="">제17조(개인정보보호)
  ① “알고다”은 이용자의 개인정보 수집시 서비스제공을 위하여 필요한 범위에서 최소한의 개인정보를 수집합니다. 

  ② “알고다”은 회원가입시 구매계약이행에 필요한 정보를 미리 수집하지 않습니다. 다만, 관련 법령상 의무이행을 위하여 구매계약 이전에 본인확인이 필요한 경우로서 최소한의 특정 개인정보를 수집하는 경우에는 그러하지 아니합니다.

  ③ “알고다”은 이용자의 개인정보를 수집·이용하는 때에는 당해 이용자에게 그 목적을 고지하고 동의를 받습니다. 

  ④ “알고다”은 수집된 개인정보를 목적외의 용도로 이용할 수 없으며, 새로운 이용목적이 발생한 경우 또는 제3자에게 제공하는 경우에는 이용·제공단계에서 당해 이용자에게 그 목적을 고지하고 동의를 받습니다. 다만, 관련 법령에 달리 정함이 있는 경우에는 예외로 합니다.

  ⑤ “알고다”이 제2항과 제3항에 의해 이용자의 동의를 받아야 하는 경우에는 개인정보관리 책임자의 신원(소속, 성명 및 전화번호, 기타 연락처), 정보의 수집목적 및 이용목적, 제3자에 대한 정보제공 관련사항(제공받은자, 제공목적 및 제공할 정보의 내용) 등 「정보통신망 이용촉진 및 정보보호 등에 관한 법률」 제22조제2항이 규정한 사항을 미리 명시하거나 고지해야 하며 이용자는 언제든지 이 동의를 철회할 수 있습니다.

  ⑥ 이용자는 언제든지 “알고다”이 가지고 있는 자신의 개인정보에 대해 열람 및 오류정정을 요구할 수 있으며 “알고다”은 이에 대해 지체 없이 필요한 조치를 취할 의무를 집니다. 이용자가 오류의 정정을 요구한 경우에는 “알고다”은 그 오류를 정정할 때까지 당해 개인정보를 이용하지 않습니다.
 
  ⑦ “알고다”은 개인정보 보호를 위하여 이용자의 개인정보를 취급하는 자를  최소한으로 제한하여야 하며 신용카드, 은행계좌 등을 포함한 이용자의 개인정보의 분실, 도난, 유출, 동의 없는 제3자 제공, 변조 등으로 인한 이용자의 손해에 대하여 모든 책임을 집니다.

  ⑧ “알고다” 또는 그로부터 개인정보를 제공받은 제3자는 개인정보의 수집목적 또는 제공받은 목적을 달성한 때에는 당해 개인정보를 지체 없이 파기합니다.

  ⑨ “알고다”은 개인정보의 수집·이용·제공에 관한 동의 란을 미리 선택한 것으로 설정해두지 않습니다. 또한 개인정보의 수집·이용·제공에 관한 이용자의 동의거절시 제한되는 서비스를 구체적으로 명시하고, 필수수집항목이 아닌 개인정보의 수집·이용·제공에 관한 이용자의 동의 거절을 이유로 회원가입 등 서비스 제공을 제한하거나 거절하지 않습니다.


</textarea>
        </li>
        <li class="checkBox check03">
            <ul class="clearfix">
                <li>개인정보처리 위탁동의(필수)</li>
                <li class="checkBtn">
                    <input type="checkbox" name="chk" class="chk">
                </li>
            </ul>

            <textarea name="" id="">제18조(“알고다“의 의무)

  ① “알고다”은 법령과 이 약관이 금지하거나 공서양속에 반하는 행위를 하지 않으며 이 약관이 정하는 바에 따라 지속적이고, 안정적으로 재화․용역을 제공하는데 최선을 다하여야 합니다.

  ② “알고다”은 이용자가 안전하게 인터넷 서비스를 이용할 수 있도록 이용자의 개인정보(신용정보 포함)보호를 위한 보안 시스템을 갖추어야 합니다.

  ③ “알고다”이 상품이나 용역에 대하여 「표시․광고의 공정화에 관한 법률」 제3조 소정의 부당한 표시․광고행위를 함으로써 이용자가 손해를 입은 때에는 이를 배상할 책임을 집니다.

  ④ “알고다”은 이용자가 원하지 않는 영리목적의 광고성 전자우편을 발송하지 않습니다.
            
</textarea>
        </li>
        <li class="checkBox check04">
            <ul class="clearfix">
                <li>마케팅 정보 제공 동의(선택)</li>
                <li class="checkBtn">
                    <input type="checkbox" name="chk" class="chk">
                </li>
            </ul>
			 <textarea name="" id="">② “알고다”가 제3자에게 구매자 개인정보를 제공할 필요가 있는 경우 1) 개인정보를 제공받는 자, 2)개인정보를 제공받는 자의 개인정보 이용목적, 3) 제공하는 개인정보의 항목, 4) 개인정보를 제공받는 자의 개인정보 보유 및 이용기간을 구매자에게 알리고 동의를 받아야 합니다. (동의를 받은 사항이 변경되는 경우에도 같습니다.)


  ③ “알고다”가 제3자에게 구매자의 개인정보를 취급할 수 있도록 업무를 위탁하는 경우에는 1) 개인정보 취급위탁을 받는 자, 2) 개인정보 취급위탁을 하는 업무의 내용을 구매자에게 알리고 동의를 받아야 합니다. (동의를 받은 사항이 변경되는 경우에도 같습니다.) 다만, 서비스제공에 관한 계약이행을 위해 필요하고 구매자의 편의증진과 관련된 경우에는 「정보통신망 이용촉진 및 정보보호 등에 관한 법률」에서 정하고 있는 방법으로 개인정보 취급방침을 통해 알림으로써 고지절차와 동의절차를 거치지 않아도 됩니다.
			 
</textarea>
        </li>
    </ul>
    <ul class="footBtwrap clearfix">
         <li><button class="fpmgBt2" id="mempage">다음</button></li>
        <li><button class="fpmgBt1" id="cancel">취소</button></li>
       
    </ul>
</form>

<script>
    window.onload = function () {
    	
      var checkAll = document.getElementById('chkAll');
      var mempage = document.getElementById('mempage');
      var cancel = document.getElementById('cancel');
      var chks = document.querySelectorAll('.chk');
      var chkBoxLength = chks.length;
      var memfrm = document.frm;
      
      
      mempage.addEventListener('click', function () {
    	  if (checkAll.checked) {
    		  memfrm.action= "Memberjoin.jsp";
    		  memfrm.submit();
      	  }else{
      		  alert("약관에 동의 하세요");
      		  return false;
      	  }
      });
      
      
      cancel.addEventListener('click', function () {
    	  memfrm.action="Login.jsp";
    	  memfrm.submit();  
      });
      
      
      // 전체동의 항목 선택시 모든 항목 체크 or 언체크 코드
  
      checkAll.addEventListener('click', function () {
        if (checkAll.checked) {
          chks.forEach(function (value) {
            value.checked = true;
          });
          
          
        } else {
          chks.forEach(function (value) {
            value.checked = false;
          });
         
        }
      });
      
      ///////////////////////////////////////////
      
      
  		// 약관동의 하나씩 체크하고 전체 체크 확인하는 코드
      for (var i = 0; i < chks.length; i++) {
        chks[i].addEventListener('click', function () {
          var count = 0;
          for (var j = 0; j < chks.length; j++) {
            if (chks[j].checked) {
              count++;
            }
          }
          if (count !== chkBoxLength) {
            checkAll.checked = false;
          } else {
            checkAll.checked = true;
          }
        });
      }
    }
    
    function cancel() {
        alert("cancel");
        joinform.action="Login.jsp";
        joinform.submit();   
   }
    
    
  </script>


</body>
</html>
    