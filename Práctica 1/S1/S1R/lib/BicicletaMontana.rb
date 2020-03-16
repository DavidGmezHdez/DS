
require_relative "Bicicleta"

module Ruby
	public
	class BicicletaMontana < Bicicleta
    
    attr_accessor :id
		
		def clonar()
			return BicicletaMontana.new(@id)
		end

		public
		def initialize(id)
			super()
      @id=id
		end
	end
end
