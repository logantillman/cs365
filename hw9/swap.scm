(define (swap x y)
    (if (< x y)
        (cons x y)
        (cons y x)))