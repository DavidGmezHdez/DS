
require_relative "Bicicleta"

module Ruby
	public
	class BicicletaCarretera < Bicicleta
    
    attr_accessor :id

		
		def clonar()
			return BicicletaCarrera.new(@id)
		end

		public
		def initialize(id)
			super()
      @id=id
		end
	end
end
