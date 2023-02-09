Feature:  Login
  Yo como usuario de la pagina reqres necesito logearme

  @login
  Scenario:  login Successfull
    Given Park necesita loguearse en la pagina
    When el envia los datos para loguearse
    Then el obtiene una respuesta exitosa
    
  @loginFailed
  Scenario:  login Successfull
    Given Park necesita loguearse en la pagina
    When el envia los datos para loguearse erroneos
    Then el obtiene una respuesta exitosa
    
