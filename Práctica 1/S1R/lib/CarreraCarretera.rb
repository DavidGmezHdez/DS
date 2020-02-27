require('./Ruby/Carrera.rb');

module Ruby
	public
	class CarreraCarretera < Carrera

		public
		def clonar()
			return self
		end

		public
		def initialize(numero)
			super(numero)
		end
    
    public 
    def correr
      puts "Comienza la carrera de carretera"
      @bicis = @bicis.shuffle
      tamanio=@bicis.lenght
      abandonos = tamanio*0.1
      puts "El numero de abandonos es #{abandonos}"
      for i in (0..abandonos)
        caido=rand(1..tamanio)
        puts "El participante #{caido} se ha retirado de la carrera de carretera"
        @bicis.delete(caido)
      end
      
    end
    
	end
end
