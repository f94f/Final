define(['model/_facturaMasterModel'], function() { 
    App.Model.FacturaMasterModel = App.Model._FacturaMasterModel.extend({
		initialize: function() {
            this.on('invalid', function(model,error) {
                Backbone.trigger('factura-master-model-error', error);
            });
        },
        validate: function(attrs, options){
        	var modelMaster = new App.Model.FacturaModel();
        	if(modelMaster.validate){
            	return modelMaster.validate(attrs.facturaEntity,options);
            }
        }
    });

    App.Model.FacturaMasterList = App.Model._FacturaMasterList.extend({
        model: App.Model.FacturaMasterModel
    });

    return  App.Model.FacturaMasterModel;

});