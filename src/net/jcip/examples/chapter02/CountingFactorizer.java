package net.jcip.examples.chapter02;

import java.math.BigInteger;
import java.util.concurrent.atomic.*;
import javax.servlet.*;

import net.jcip.annotations.*;

/**
 * CountingFactorizer
 *
 * Servlet that counts requests using AtomicLong
 * 使用AtomicLong类型的变量来统计已处理请求的数量
 */
@ThreadSafe
public class CountingFactorizer extends GenericServlet implements Servlet {
    private final AtomicLong count = new AtomicLong(0);

    public long getCount() { return count.get(); }

    public void service(ServletRequest req, ServletResponse resp) {
        BigInteger i = extractFromRequest(req);
        BigInteger[] factors = factor(i);
        count.incrementAndGet();
        encodeIntoResponse(resp, factors);
    }

    void encodeIntoResponse(ServletResponse res, BigInteger[] factors) {}
    BigInteger extractFromRequest(ServletRequest req) {return null; }
    BigInteger[] factor(BigInteger i) { return null; }
}
