<%--
  Created by IntelliJ IDEA.
  User: yve
--%>
<!-- 首页 -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page trimDirectiveWhitespaces="true" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
	<title>博物馆评估管理系统</title>

	<%@include file="/Views/Common/Import.jsp"%>
    <link rel="stylesheet" type="text/css" href="/Content/Styles/home.css">
</head>
<body>
<div class="page-wrapper">
	<!-- 导航栏 -->
	<div class="nav-wrap">
        <%@ include file="/Views/Common/Navbar.jsp"%>
	</div>
	<div class="content-wrap">
		<!-- header -->
        <div class="header-wrap">
            <%@ include file="/Views/Common/Header.jsp"%>
        </div>
		<!-- 内容区 -->
		<div class="container-wrap">
			<div class="container">
				<marquee behavior="scroll" direction="up" loop="-1"
						 onmouseover=this.stop() onmouseout=this.start()>
					<h1>国家一级博物馆运行评估规则（试行）</h1>

					<br><h2>第一章 总 则</h2>

					<br><h3>第一条</h3>	为加强国家一级博物馆（以下简称一级博物馆）的管理，规范一级博物馆的运行评估工作，根据《博物馆管理办法》、《全国博物馆评估办法（试行）》等相关法律法规，制定本规则。
					<br><h3>第二条</h3>	对一级博物馆的运行状况进行评估，旨在鼓励先进，淘汰落后，提高一级博物馆管理、运行水平，推动博物馆体制机制创新，促进博物馆事业发展。
					<br>评估内容包括：藏品管理、科学研究、陈列展览与社会教育、公共关系与服务、博物馆管理与发展建设等。
					<br><h3>第三条</h3>	评估工作坚持“公平、公正、公开”的原则。
					<br><h3>第四条</h3>  国家文物局定期组织一级博物馆运行评估。评估工作由中国博物馆学会（以下简称:博物馆学会）负责实施。

					<br><h2>第二章 评估组织</h2>

					<br><h3>第五条</h3>	 国家文物局组织一级博物馆运行评估工作，其主要职责是：
					<br>审核评估工作方案和有关规章制度，发布评估通知；
					<br>监督协调评估工作；
					<br>审核评估报告，审定并公布评估结果。
					<br><h3>第六条</h3>	 博物馆学会负责实施一级博物馆的运行评估工作，其主要职责是：
					<br>编制和修订评估规则、指标体系和实施方案；
					<br>受理评估申报；
					<br>开展评估工作；
					<br>撰写评估报告和评估工作报告，报送国家文物局审核。
					<br><h3>第七条</h3>	各省、自治区、直辖市文物行政部门协助组织评估工作，其主要职责是：
					<br>组织本行政区划内一级博物馆参加评估；
					<br>审核评估申报材料的规范性和完整性；
					<br>为评估工作给予协调和支持。
					<br><h3>第八条</h3>	 一级博物馆应认真准备并积极参加评估工作，其主要职责是：
					<br>按要求填报《国家一级博物馆运行评估申报书》（以下简称评估申报书）；
					<br>确保评估申报书及相关材料的完整性、真实性和准确性；
					<br>准备评估申报书所涉及的有关证明材料，以备现场抽查复核。

					<br><h2>第三章 评估程序</h2>

					<br><h3>第九条</h3>  一级博物馆应在评估通知印发后2个月内，按照评估通知的要求，经省、自治区、直辖市文物行政部门审核后向博物馆学会报送评估申报书及相关材料。
					<br><h3>第十条</h3>  博物馆学会于申报截止之日起15日内对评估申报材料进行形式审核，协调申报单位补充完善评估材料。
					<br><h3>第十一条</h3>  博物馆学会组织开展评估活动。评估活动分为定性评估、定量评估和抽查复核。
					<br><h3>第十二条</h3>  定性评估采取专家通信方式。
					<br>（一）定性评估工作应于评估申报材料的形式审核结束后15日内完成。
					<br>（二）定性评估按“国家一级博物馆运行评估指标体系”一级评估指标分组进行，每组专家为不少于3名的奇数。
					<br>（三）定性评估由专家根据评估指标体系对定性评估内容进行评价打分，并写出书面评估意见。
					<br><h3>第十三条</h3>  定量评估
					<br>定量评估由博物馆学会汇总评估申报书中的有关量化数据，运用专门的统计计算系统进行处理，自动生成定量评估分值。
					<br><h3>第十四条</h3>  抽查复核
					<br>（一）抽查复核在定性评估和定量评估结束之日起15日内完成，各抽查复核组至少包括3名专家，博物馆学会指定1名专家担任抽查复核组组长。
					<br>（二）抽查复核由博物馆学会分类、随机抽取10%左右的一级博物馆，对照申报材料进行现场复核。
					<br>（三）抽查复核组根据现场抽查复核情况，写出书面复核意见，提交博物馆学会。

					<br><h2>第四章 评估结果</h2>

					<br><h3>第十五条</h3>  定性评估、定量评估和抽查复核结束后，由博物馆学会负责组织撰写评估报告，并拟定初评结果，报国家文物局审定。
					<br><h3>第十六条</h3>  经国家文物局审定的初评结果，由博物馆学会向社会公示，公示期为10天。评结果分为合格、基本合格和不合格3个等级。
					<br><h3>第十七条</h3>  初评结果公示期满后，由博物馆学会将公示情况报送国家文物局。国家文物局审定并公布评估结果。
					<br><h3>第十八条</h3>  评估结果为“基本合格”的一级博物馆，应根据评估意见进行改进。连续两次评估结果为“基本合格”的，将被取消“国家一级博物馆”称号。
					<br><h3>第十九条</h3>  评估结果为“不合格”的一级博物馆，将被取消“国家一级博物馆”称号。

					<br><h2>第五章 保障措施</h2>

					<br><h3>第二十条</h3>  未按评估通知如期报送申报材料且未申明正当理由的，按自动放弃“国家一级博物馆”称号处理。
					<br><h3>第二十一条</h3>  参评单位不得以任何方式妨碍评估工作的正常开展。
					<br><h3>第二十二条</h3>  对评估过程和结果持有异议的单位和个人，可于公示期内向博物馆学会提交书面意见及有关材料。
					<br><h3>第二十三条</h3>  评估专家应从国家文物局核定的评估专家库中随机抽选。
					<br><h3>第二十四条</h3>  评估工作实行回避制度。与参评单位有直接利害关系的评估专家及评估工作人员，不得参与该单位的评估活动。
					<br><h3>第二十五条</h3>  参与评估工作的单位和人员，应当在评估工作中严格遵守国家法律、法规及有关工作规定，履行相关职责和义务。
					<br><h3>第二十六条</h3>  评估中如发现参评单位弄虚作假或申报材料严重不实的，将被取消“国家一级博物馆”称号。

					<br><h2>第六章 附 则</h2>
					<br><h3>第二十七条</h3>	本规则自发布之日起施行。
				</marquee>
			</div>
		</div>
	</div>
</div>
</body>
</html>