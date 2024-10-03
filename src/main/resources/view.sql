SELECT * from DespachosWs dws LEFT JOIN [ProcessControl] pc ON dws.NUMERO_DESPACHO NOT IN (SELECT Nconduce FROM ProcessControl )

