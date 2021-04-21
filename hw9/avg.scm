(define avg (lambda (L)
    (cond
        ((null? L) 0)
        (#t (+ (car L) (avg (cdr L)))))))