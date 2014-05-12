define(['model/_ordenReaprovicionamientoMasterModel'], function() { 
    App.Model.OrdenReaprovicionamientoMasterModel = App.Model._OrdenReaprovicionamientoMasterModel.extend({
		initialize: function() {
            this.on('invalid', function(model,error) {
                Backbone.trigger('ordenReaprovicionamiento-master-model-error', error);
            });
        },
        validate: function(attrs, options){
        	var modelMaster = new App.Model.OrdenReaprovicionamientoModel();
        	if(modelMaster.validate){
            	return modelMaster.validate(attrs.ordenReaprovicionamientoEntity,options);
            }
        }
    });

    App.Model.OrdenReaprovicionamientoMasterList = App.Model._OrdenReaprovicionamientoMasterList.extend({
        model: App.Model.OrdenReaprovicionamientoMasterModel
    });

    return  App.Model.OrdenReaprovicionamientoMasterModel;

});