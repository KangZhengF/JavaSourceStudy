package com.kang.thread.threadapi;

import java.security.*;

public abstract class SafeRunnable implements Runnable {
    public abstract void protectMethod();

    @Override
    public void run() {
        SecurityManager securityManager = new SecurityManager();
        System.setSecurityManager(securityManager);
        // 代码来源
        CodeSource codeSource = new CodeSource(null, (CodeSigner[]) null);
        Permissions permissions = new Permissions();
        ProtectionDomain protectionDomain = new ProtectionDomain(codeSource, permissions);
        AccessControlContext accessControlContext = new AccessControlContext(new ProtectionDomain[]{protectionDomain});
        AccessController.doPrivileged(new PrivilegedAction<Object>() {
            @Override
            public Object run() {
                // 第三方实现
                protectMethod();
                return null;
            }
        }, accessControlContext);
    }
}
