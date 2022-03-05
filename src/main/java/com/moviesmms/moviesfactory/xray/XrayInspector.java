package com.moviesmms.moviesfactory.xray;

import java.util.Map;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.amazonaws.xray.entities.Subsegment;
import com.amazonaws.xray.spring.aop.AbstractXRayInterceptor;

@Aspect
@Component
public class XrayInspector extends AbstractXRayInterceptor{

	@Override
	@Pointcut("@within(com.amazonaws.xray.spring.aop.XRayEnabled) && bean(*)")
	protected void xrayEnabledClasses() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected Map<String, Map<String, Object>> generateMetadata(ProceedingJoinPoint pjp, Subsegment subsegment) {
		// TODO Auto-generated method stub
		return super.generateMetadata(pjp, subsegment);
	}



	
	
	
	
}
