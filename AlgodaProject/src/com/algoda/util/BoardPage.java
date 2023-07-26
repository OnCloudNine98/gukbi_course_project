package com.algoda.util;

public class BoardPage {
	//단어장 페이지 메서드
   public static String pagingStr(int totalCount, int pageSize, int blockPage,
            int pageNum, String reqUrl) {
      
      String pagingStr = "";
      int totalPages = (int)Math.ceil((double)totalCount / pageSize);
      
      //이전페이지 블록가기 출력
      int pageTemp = (((pageNum - 1) / blockPage) * blockPage) + 1;
      if(pageTemp != 1) {
    	  	//첫페이지 버튼
    	  	pagingStr += "<button type=\"button\" class=\"btn btn-round btn-default\""
    	  				+ "onclick=\"location.href=' "
    	  				+reqUrl+ "?pageNum=1 ';\"> << </button>";
    	  	pagingStr += "&nbsp;";
    	  	//이전 블럭 버튼
    	  	pagingStr += "<button type=\"button\" class=\"btn btn-round btn-default\""
    	  				+ "onclick=\"location.href=' "
    	  				+reqUrl+ "?pageNum="+(pageTemp - 1)
    	  				+ " ';\"> < </button>";

      }
      
      //각 페이지 번호 출력
      int blockCount = 1;
      while(blockCount <= blockPage && pageTemp <= totalPages){
         if(pageTemp == pageNum) {
            pagingStr += "&nbsp;" + pageTemp + "&nbsp;";
         }else {
            pagingStr += "&nbsp;<button type=\"button\" class=\"btn btn-default\" "
            			+ "onclick=\"location.href=' "
            			+ reqUrl + "?pageNum=" + pageTemp
                        + " ';\"> " + pageTemp + "</button>&nbsp;";
         }
         
         pageTemp++;  // 1 , 6 , 11 , 16
         blockCount++;
         
      }
           
      
      //다음페이지 블록가기 출력
      if(pageTemp <= totalPages) {
    	  //다음 블럭 버튼
    	  pagingStr += "<button type=\"button\" class=\"btn btn-round btn-default\""
			  		+ "onclick=\"location.href=' "
			  		+reqUrl+ "?pageNum="+totalPages
			  		+ " ';\"> > </button>";
    	  pagingStr += "&nbsp;";
    	  pagingStr += "<button type=\"button\" class=\"btn btn-round btn-default\""
    			  	+ "onclick=\"location.href=' "
    			  	+reqUrl+ "?pageNum="+totalPages 
    			  	+" ';\"> >> </a>";
    	  
      }
      
      return pagingStr;
   }
   //월드 리스트 페이지 메서드
   public static String pagingStr(int totalCount, int pageSize, int blockPage,
            String wordLevel,String wordDay ,int pageNum,String reqUrl) {
     
     String pagingStr = "";
     int totalPages = (int)Math.ceil((double)totalCount / pageSize);
     
     //이전페이지 블록가기 출력
     int pageTemp = (((pageNum - 1) / blockPage) * blockPage) + 1;
     if(pageTemp != 1) {
   	  	//첫페이지 버튼
   	  	pagingStr += "<button type=\"button\" class=\"btn btn-round btn-default\""
   	  				+ "onclick=\"location.href=' "
   	  				+reqUrl+ "?pageNum=1&wordLevel="+wordLevel+"&wordDay="+wordDay +" ';\"> << </button>";
   	  	pagingStr += "&nbsp;";
   	  	//이전 블럭 버튼
   	  	pagingStr += "<button type=\"button\" class=\"btn btn-round btn-default\""
   	  				+ "onclick=\"location.href=' "
   	  				+reqUrl+ "?pageNum="+(pageTemp - 1)+"&wordLevel="+wordLevel+"&wordDay="+wordDay 
   	  				+ " ';\"> < </button>";

     }
     
     //각 페이지 번호 출력
     int blockCount = 1;
     while(blockCount <= blockPage && pageTemp <= totalPages){
        if(pageTemp == pageNum) {
           pagingStr += "&nbsp;" + pageTemp + "&nbsp;";
        }else {
           pagingStr += "&nbsp;<button type=\"button\" class=\"btn btn-default\" "
           			+ "onclick=\"location.href=' "
           			+ reqUrl + "?wordLevel=" + wordLevel+"&wordDay="+wordDay+"&pageNum="+pageTemp
                    + " ';\"> " + pageTemp + "</button>&nbsp;";
        }
        
        pageTemp++;  // 1 , 6 , 11 , 16
        blockCount++;
        
     }
          
     
     //다음페이지 블록가기 출력
     if(pageTemp <= totalPages) {
   	  //다음 블럭 버튼
   	  pagingStr += "<button type=\"button\" class=\"btn btn-round btn-default\""
			  		+ "onclick=\"location.href=' "
			  		+reqUrl+ "?pageNum="+totalPages+"&wordLevel="+wordLevel+"&wordDay="+wordDay
			  		+ " ';\"> > </button>";
   	  pagingStr += "&nbsp;";
   	  pagingStr += "<button type=\"button\" class=\"btn btn-round btn-default\""
   			  	+ "onclick=\"location.href=' "
   			  	+reqUrl+ "?pageNum="+totalPages+"&wordLevel="+wordLevel+"&wordDay="+wordDay
   			  	+" ';\"> >> </a>";
   	  
     }
     
     return pagingStr;
  }
}